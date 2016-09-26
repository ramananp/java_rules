package excelUpdatesFeatureFile.backgroundSection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import excelUpdatesFeatureFile.ExcelUtility;
import excelUpdatesFeatureFile.ReadExcelTestScriptDataProperties;



//Updates all of the property files containing the test data for background steps

public class UpdateAllPropertyFiles {

	static XSSFSheet ExcelWSheet = null;
	static Properties prop = new Properties();
	static ExcelUtility excelUtility = new ExcelUtility();
	static ReadExcelTestScriptDataProperties mainProperties = new ReadExcelTestScriptDataProperties();
	
	public static void main(String[] args) throws Exception {	
		excelPropertiesMapperLogin(mainProperties.getLoginInfoStartingRow(), mainProperties.getLoginInfoStartingColumn(), mainProperties.getLoginInfoEndingColumn(), mainProperties.getLoginInfoPropertiesLocation(), mainProperties.getLoginInfoTitle());
	}

	public static void excelPropertiesMapperLogin(int StartingRow, int StartingColumn, int EndingColumn, String propertyFileLocation, String propertyTitle) throws IOException, Exception{
		ExcelWSheet = excelUtility.setExcelFile(mainProperties.getExcelLoaction(), "Table of Contents");
		Iterator<Row> excelWSheetIterator = ExcelWSheet.iterator();
		while (excelWSheetIterator.hasNext()) {

//Step 1 - Extract Excel data on Table of Contents sheet		

			List<String> loginInfo = new ArrayList<String>();
			String column1 = excelUtility.getCellData(StartingRow, 0);

			if (column1 == null) {
				break;
			}
			/*
				Change the starting value of StartingColumn if data does not start in column
				Adjust ending column as needed
				EndingColumn - StartingColumn = totalNumOfColsPulled
				3 - 0 = 3 items of data in the row/number of columns
			 */
			for(StartingColumn = 0; StartingColumn < EndingColumn; StartingColumn++){
				if(excelUtility.getCellData(StartingRow, StartingColumn) != null && !excelUtility.getCellData(StartingRow, StartingColumn).equals("")){
					String col = excelUtility.getCellData(StartingRow, StartingColumn).replace("\"", "");
					loginInfo.add(col);
				}
				else{
					break;
				}				
			}
			StartingRow++;
			if(loginInfo.size() == 0){
				break;
			}
//Step 2 - Set properties of the target properties file to include the test data
			prop.setProperty("SID"+loginInfo.get(0).replace(" ", ""), loginInfo.get(1));
			prop.setProperty("Password" + loginInfo.get(0).replace(" ", ""), loginInfo.get(2));
//Step 3 - Repeat steps 1 & 2 for each row of the background list
		}
//Step 4 - Write properties content to the target properties file
		File f = new File(propertyFileLocation);
		OutputStream out = new FileOutputStream(f);
		prop.store(out, "This the username and password information to use to login");
		InputStream in = new FileInputStream(f);
		prop.load(in);
		prop.clear();
		System.out.println(">> Updated Property File : " + propertyTitle);
	}
}
