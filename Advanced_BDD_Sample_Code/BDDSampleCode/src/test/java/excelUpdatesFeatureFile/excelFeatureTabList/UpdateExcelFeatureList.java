package excelUpdatesFeatureFile.excelFeatureTabList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excelUpdatesFeatureFile.ExcelUtility;
import excelUpdatesFeatureFile.ReadExcelTestScriptDataProperties;

//Executes the update for feature file tab list in the Excel

public class UpdateExcelFeatureList {
	static ExcelUtility excelUtility = new  ExcelUtility();
	static ReadExcelTestScriptDataProperties mainProperties = new ReadExcelTestScriptDataProperties();
	
	public static void main(String[] args) throws Exception {
//Step 1 - Get list of Sheet Names from Excel and store in a Map		
		XSSFWorkbook ExcelWBook = excelUtility.setExcelWBook(mainProperties.getExcelLoaction());
		int numOfSheets = ExcelWBook.getNumberOfSheets();
		int tabNum;
		
		Map<Integer, String> sheetNames = new HashMap<Integer, String>();	
		for(tabNum = 0; tabNum < numOfSheets; tabNum++){
			sheetNames.put(tabNum, ExcelWBook.getSheetName(tabNum));
		}
		
		int startingRow = mainProperties.getFeatureTabListStartingRow();
		int startingColumn = mainProperties.getFeatureTabListStartingColumn();
		int index = 1;
//Step 3 - Iterate through Map to update the entire Table of Contents		
		System.out.println("Updating Table of Contents...");
		for(int i = index; i < numOfSheets; i++){
//Step 2 - Write sheet names in Table of Contents Excel tab
			if(numOfSheets == i){
				break;
			}
			System.out.println("Tab Num: " + i + "     Content Of Tab: " + sheetNames.get(i));
			writeToExcel(startingRow, startingColumn, i);
			writeToExcel(startingRow, startingColumn + 1, sheetNames.get(i));
			startingRow = startingRow + 1;
		}
		System.out.println("Total Number of Feature Files Updated by the Excel: " + (numOfSheets - 1));
		System.out.println();
		System.out.println("******************************Feature File List In Excel Is Updated******************************");
		System.out.println();
	}
	
	public static void writeToExcel(int Row, int Column, String Value) throws FileNotFoundException, IOException{
		FileInputStream in = new FileInputStream(new File(mainProperties.getExcelLoaction()));
		XSSFWorkbook writeToExcel = new XSSFWorkbook(in);
		XSSFSheet sheet = writeToExcel.getSheetAt(0);
		XSSFRow row = sheet.getRow(Row);
		XSSFCell value = row.getCell(Column);
		//If the cell is blank it will come back with a null cell reference, so you cannot set the value
		//By changing the blank cells type first the cell does not come back as null
		if(value.getCellType() == Cell.CELL_TYPE_BLANK){
			value.setCellType(Cell.CELL_TYPE_STRING);
			value.setCellValue(Value);
		}else{
			value.setCellValue(Value);
		}
		
		in.close();
		
		FileOutputStream file = new FileOutputStream(new File(mainProperties.getExcelLoaction()));			
		writeToExcel.write(file);
		file.close();
	}
	
	//Overloaded method of the above method
	public static void writeToExcel(int Row, int Column, int Value) throws FileNotFoundException, IOException{
		FileInputStream in = new FileInputStream(new File(mainProperties.getExcelLoaction()));
		XSSFWorkbook writeToExcel = new XSSFWorkbook(in);
		XSSFSheet sheet = writeToExcel.getSheetAt(0);
		XSSFRow row = sheet.getRow(Row);
		XSSFCell value = row.getCell(Column);
		
		if(value.getCellType() == Cell.CELL_TYPE_BLANK){
			value.setCellType(Cell.CELL_TYPE_STRING);
			value.setCellValue(Value);
		}else{
			value.setCellValue(Value);
		}
		
		in.close();
		
		FileOutputStream file = new FileOutputStream(new File(mainProperties.getExcelLoaction()));			
		writeToExcel.write(file);
		file.close();
	}
}
