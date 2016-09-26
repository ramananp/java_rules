package excelUpdatesFeatureFile;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;

//This sets the location of the excel document
//This needs to be separate from getting the work sheet, so workbook wide information like number of sheets can be extracted
	public XSSFWorkbook setExcelWBook(String Path) throws Exception {
		FileInputStream ExcelFile = null;
		ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		return ExcelWBook;
	}

	public XSSFWorkbook getExcelWBook() {
		return ExcelWBook;
	}

	//This finds the specific sheet in the Excel
//A sheet represents a feature file
	public XSSFSheet setExcelFile(String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile = null;
		try {
			ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			return ExcelWSheet;
		} finally {
			ExcelFile.close();
		}
	}

//This retrieves the data from a specific cell
//converts it into a java data type	and stores the value
	public String getCellData(int RowNum, int ColNum) throws Exception {
		if (ExcelWSheet.getRow(RowNum) != null) {
			//Whatever work sheet you set will be used with the get Cell Data method
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = "";
			if(null !=Cell){
				//This checks if the cell has a number in it
				if (0 == (Cell.getCellType())) {
					//Need to determine if the number should be converted into a double or integer in the feature file
					String item = Double.toString((double) Cell.getNumericCellValue());
					if(!item.endsWith(".0")){
						String val = Double.toString((double) Cell.getNumericCellValue());
						CellData = new BigDecimal(val).toPlainString();
					}
					else{
						String val = Integer.toString((int) Cell.getNumericCellValue());
						CellData = new BigDecimal(val).toPlainString();
					}
				} 
//Checks if it is just a text value 
				else if (1 == (Cell.getCellType())) {
					//adds quotes if not a Scenario Outline name
					if(Cell.getColumnIndex() != 0){
						CellData = "\"" + Cell.getStringCellValue() + "\""; 
					}
					//Do not add quotes if it a scenario outline name, in other words the first column of a feature file tab
					else if(Cell.getColumnIndex() == 0){
						CellData = Cell.getStringCellValue();
					}
					
				}
//Checks if it is a formula, like a reference to the table of contents
				else if (2 == Cell.getCellType()){
					//After getting the formula value you have to check if it is number or text again
					if(Cell.getCachedFormulaResultType() == 1){
						
						if(Cell.getColumnIndex() != 0){
							CellData = "\"" + Cell.getStringCellValue() + "\"";
						}
						else if(Cell.getColumnIndex() == 0){
							CellData = Cell.getStringCellValue();
						}
					}
					else if(Cell.getCachedFormulaResultType() == 0){
						String item = Double.toString((double) Cell.getNumericCellValue());
						if(!item.endsWith(".0")){	
							String val = Double.toString((double) Cell.getNumericCellValue());
							CellData = new BigDecimal(val).toPlainString();
						}
						else{
							String val = Integer.toString((int) Cell.getNumericCellValue());
							CellData = new BigDecimal(val).toPlainString();
						}
					}
				}
				
			}
			
			return CellData;
		} else {
			return null;
		}
	}
}
