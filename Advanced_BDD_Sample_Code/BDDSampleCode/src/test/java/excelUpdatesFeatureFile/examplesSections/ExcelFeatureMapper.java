
package excelUpdatesFeatureFile.examplesSections;

//The purpose of this file is to update all of the Examples sections in all of the feature files
//Should ran any time the excel data is changed
//It does not need to be ran every time the tests are executed, because the data in the feature files is already updated

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excelUpdatesFeatureFile.ExcelUtility;
import excelUpdatesFeatureFile.ReadExcelTestScriptDataProperties;

public class ExcelFeatureMapper {

	static ExcelUtility excelUtility = new ExcelUtility();
	static ReadExcelTestScriptDataProperties mainProperties = new ReadExcelTestScriptDataProperties();
	
	public static void main(String[] args) throws Exception {	
		XSSFSheet ExcelWSheet = null;
		String featureFileName = "";
		XSSFWorkbook ExcelWBook = null;
		Integer featureFileTabNumber = 1; //The counter starts at 1, so the table of contents page is excluded
		
//Step 1 - Convert Excel Data into Java Objects	
		ExcelWBook = getExcelWBook(ExcelWBook);
		
		while(featureFileTabNumber < ExcelWBook.getNumberOfSheets()){

			FeatureFile feature = new FeatureFile();
			Map<Integer, ScenarioOutline> scenarioMap = feature.getScenarioMap();
			featureFileName =  ExcelWBook.getSheetName(featureFileTabNumber);
			ExcelWSheet = excelUtility.setExcelFile(mainProperties.getExcelLoaction(), featureFileName);
			System.out.println(">> Feature File Name " +  featureFileName);
			mapExcelAndScenarios(ExcelWSheet, scenarioMap);
//Step 2 - Create list based off original feature file and Java Objects
			String FeatureFilePath = mainProperties.getFeatureFileLoaction() + featureFileName + ".feature";
			List<String> updatedFeatureFileContent = readCurrentFeatureFileAndAddExcelData(FeatureFilePath, scenarioMap);
//Step 3 - Overwrite the original feature file, with list
			writeNewFeatureFile(updatedFeatureFileContent, FeatureFilePath);
//Step 4 - Repeat the process for each feature file tab
			featureFileTabNumber++; 
		}
		System.out.println();
		System.out.println("**********************************All Feature Files Are Updated**********************************");
		System.out.println();
	}

//Step 1 -Get Excel work book 
	public static XSSFWorkbook getExcelWBook(XSSFWorkbook ExcelWBook) throws Exception{
			ExcelWBook = excelUtility.setExcelWBook(mainProperties.getExcelLoaction());
			System.out.println("Referenced Excel Location: " +  mainProperties.getExcelLoaction());
			System.out.println("Number of Feauture File Tabs in Workbook: " + (ExcelWBook.getNumberOfSheets()-1));
			System.out.println();
		return ExcelWBook;
	}

//Step 3 -Map the excel data to the associated feature file and scenario outline name
	public static void mapExcelAndScenarios(XSSFSheet ExcelWSheet, Map<Integer, ScenarioOutline> scenarioMap) throws Exception{
		Iterator<Row> excelWSheetIterator = ExcelWSheet.iterator();
		int iRow = 0;
		Map<String, String> firstOccuranceOfScenarioOutline = new HashMap<String, String>();
		int headerRow = 0;
		int totalNumOfColAnExampleSectionCanHave = mainProperties.getTotalNumOfColAnExampleSectionCanHave();
		while (excelWSheetIterator.hasNext()) {
		
			
			iRow = iRow + 1;

			String column1 = excelUtility.getCellData(iRow, 0);

			if (column1 == null) {

				break;
			}
			
			List<String> columns = new ArrayList<String>();
			for(int numOfCol = 0; numOfCol < totalNumOfColAnExampleSectionCanHave; numOfCol++){
				
				if(excelUtility.getCellData(iRow, numOfCol) != null && !excelUtility.getCellData(iRow, numOfCol).equals("")){
					String col = excelUtility.getCellData(iRow, numOfCol);
					
					if(!firstOccuranceOfScenarioOutline.containsKey(excelUtility.getCellData(iRow, 0))){
						firstOccuranceOfScenarioOutline.put(excelUtility.getCellData(iRow, 0), excelUtility.getCellData(iRow, 0));
						headerRow = iRow;
					}
					//The excel utility automatically adds " " to strings
					//The values of each header row of an Examples section should not have " " 
					if(headerRow == iRow){
						col = col.replace("\"", "");
					}
					if(numOfCol > 0){
						columns.add(col);
					}
				}
				else{
					break;
				}
			}
			ExamplesRow newRow = new ExamplesRow();
			newRow.columns = columns;

			if (scenarioMap.containsKey(column1.trim().hashCode())) {
				List<ExamplesRow> rows = scenarioMap.get(column1.hashCode()).getRows();
				rows.add(newRow);
			} else {
				ScenarioOutline scenario = new ScenarioOutline();
				scenario.setScenarioOutline(column1);
				scenario.getRows().add(newRow);						
				scenarioMap.put(column1.trim().hashCode(), scenario);
			}
		}
	}

//Step 4 -Read the current feature file and add the appropriate Excel data
	public static List<String> readCurrentFeatureFileAndAddExcelData(String FeatureFilePath, Map<Integer, ScenarioOutline> scenarioMap ){
		List<String> updatedFeatureFileContent = new ArrayList<String>();
		String scenarioOutlinePattern = "Scenario Outline:";
		String scenarioPattern = "Scenario:";
		String exampleHeaderPattern = "Examples:";
		Scanner sc = null;
		String scenarioOutline = "";
		String scenario = "";
		Integer currentScenarioHash = null;
		Pattern examplePattern = Pattern.compile("\\|.*\\|");
		try {
			//If this is true any existing |...| pattern will be removed
			//This allows data tables to still be used between scenarios/ scenarios Outlines and Examples
			boolean examplesTrigger = false; 
			sc = new Scanner(new File(FeatureFilePath));
			while(sc.hasNextLine()){
				//Adds the name of scenario Outlines
				if(sc.findInLine(scenarioOutlinePattern) != null){
					examplesTrigger = false;
					scenarioOutline = sc.nextLine().trim();
					currentScenarioHash = scenarioOutline.trim().hashCode();
					updatedFeatureFileContent.add(scenarioOutlinePattern + " " + scenarioOutline);
				}
				//Adds scenario
				if(sc.findInLine(scenarioPattern) != null){
					examplesTrigger = false;
					scenario = sc.nextLine().trim();
					updatedFeatureFileContent.add(scenarioPattern + " " +scenario);
				}
				//Add test data from Excel after the keyword Examples
				else if(!scenarioOutline.equals("") && sc.findInLine(exampleHeaderPattern) != null){
					examplesTrigger = true;
					updatedFeatureFileContent.add(exampleHeaderPattern);
					if(currentScenarioHash != null){
						if(scenarioMap.containsKey(currentScenarioHash)){
							for(ExamplesRow row: scenarioMap.get(currentScenarioHash).getRows()){
								updatedFeatureFileContent.add(row.toString());
							}							
						}
						else{
							System.out.println("Scenario not found: " + scenarioOutline);
						}
					}
					sc.nextLine();
				}
				//Removes existing examples	
				else if(examplesTrigger && sc.findInLine(examplePattern) != null){
					sc.nextLine();
				}
				//Adds all other lines
				else{
					updatedFeatureFileContent.add(sc.nextLine());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		return updatedFeatureFileContent;
	}

//Step 5 - With the contents of the updated feature file stored in java, use this information to overwrite the original feature file
	public static void writeNewFeatureFile(List<String> updatedFeatureFileContent, String FeatureFilePath){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(FeatureFilePath, false));

			for(String line :  updatedFeatureFileContent){
				out.write(line);
				out.newLine();
			}

			out.close();

		} catch (IOException e) {
			System.out.println("There was an error" + e);
		}		
	}
}

