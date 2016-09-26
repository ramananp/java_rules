package excelUpdatesFeatureFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//This abstracts the data in the main properties file, excelTestScriptData.properties

public class ReadExcelTestScriptDataProperties{
	
	Properties prop = new Properties();
//Reference the main properties file
		public void getPropertiesFile() throws IOException{	
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("excelUpdatesFeatureFile/excelTestScriptData.properties");
			prop.load(in);
		}
//Get the value in the properties file based off the key	
		public String getPropertiesFileValue(String Key) throws IOException{
			getPropertiesFile();
			
			Object Value = prop.get(Key);
			String formatedValue = Value.toString();
			return formatedValue;
		}
//getPropertiesFile to return an integer
		public int getPropertiesFileValueInt(String Key) throws IOException{
			getPropertiesFile();
			Object value = prop.get(Key);
			String stringValue = value.toString();
			int intValue = Integer.parseInt(stringValue);
			return intValue;
		}	

//Create get methods to get the data from the properties files, so it is easy to reference in the rest of the Excel Mapper
		public String getExcelLoaction() throws IOException{
			String excelLocation = getPropertiesFileValue("excelLocation");
			return excelLocation;
		}

		public String getFeatureFileLoaction() throws IOException{
			String featureFileLocation = getPropertiesFileValue("featureFileLocation");
			return featureFileLocation;
		}
		
		public String getLoginInfoPropertiesLocation() throws IOException{
			String loginInfoPropertiesLocation = getPropertiesFileValue("loginInfoPropertiesLocation");
			return loginInfoPropertiesLocation;
		}
		
		public String getLoginInfoTitle() throws IOException{
			String loginInfoTitle = getPropertiesFileValue("loginInfoTitle");
			return loginInfoTitle;
		}
		
		public int getLoginInfoStartingRow() throws IOException{
			int loginInfoStartingRow = getPropertiesFileValueInt("loginInfoStartingRow");
			return loginInfoStartingRow;
		}
		
		public int getLoginInfoStartingColumn() throws IOException{
			int loginInfoStartingColumn = getPropertiesFileValueInt("loginInfoStartingColumn");
			return loginInfoStartingColumn;
		}
		
		public int getLoginInfoEndingColumn() throws IOException{
			int loginInfoEndingColumn = getPropertiesFileValueInt("loginInfoEndingColumn");
			return loginInfoEndingColumn;
		}
		
		public String getAcctPartialPropertiesLocation() throws IOException{
			String acctPartialPropertiesLocation = getPropertiesFileValue("acctPartialPropertiesLocation");
			return acctPartialPropertiesLocation;
		}
		
		public String getAcctPartialTitle() throws IOException{
			String acctPartialTitle = getPropertiesFileValue("acctPartialTitle");
			return acctPartialTitle;
		}
		
		public int getAcctPartialStartingRow() throws IOException{
			int acctPartialStartingRow = getPropertiesFileValueInt("acctPartialStartingRow");
			return acctPartialStartingRow;
		}
		
		public int getAcctPartialStartingColumn() throws IOException{
			int acctPartialStartingColumn = getPropertiesFileValueInt("acctPartialStartingColumn");
			return acctPartialStartingColumn;
		}
		
		public int getAcctPartialEndingColumn() throws IOException{
			int acctPartialEndingColumn = getPropertiesFileValueInt("acctPartialEndingColumn");
			return acctPartialEndingColumn;
		}
		
		public int getTotalNumOfColAnExampleSectionCanHave() throws IOException{
			int totalNumOfColAnExampleSectionCanHave = getPropertiesFileValueInt("totalNumOfColAnExampleSectionCanHave");
			return totalNumOfColAnExampleSectionCanHave;
		}
		
		public int getFeatureTabListStartingRow() throws IOException{
			int featureTabListStartingRow = getPropertiesFileValueInt("featureTabListStartingRow");
			return featureTabListStartingRow;
		}

		public int getFeatureTabListStartingColumn() throws IOException{
			int featureTabListStartingColumn = getPropertiesFileValueInt("featureTabListStartingColumn");
			return featureTabListStartingColumn;
		}
}