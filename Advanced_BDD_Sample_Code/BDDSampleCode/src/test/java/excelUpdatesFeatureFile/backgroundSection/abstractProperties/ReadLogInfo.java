package excelUpdatesFeatureFile.backgroundSection.abstractProperties;

//Step 5 - Abstract properties data
//This file abstracts the reading of the properties file, so it is easier to reference in your test scripts

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import excelUpdatesFeatureFile.ReadExcelTestScriptDataProperties;

public class ReadLogInfo {

	Properties prop = new Properties();
	ReadExcelTestScriptDataProperties mainProperties = new ReadExcelTestScriptDataProperties();
//Get properties file
	public void getPropertiesFile() throws IOException{
		
		File f = new File(mainProperties.getLoginInfoPropertiesLocation());
		InputStream in = new FileInputStream(f);
		prop.load(in);
	}
//Get the value in the properties file based off the key	
	public String getPropertiesFileValue(String Key) throws IOException{
		getPropertiesFile();
		Object Value = prop.get(Key);
		String formatedValue = Value.toString();
		return formatedValue;
	}
//Client Service login information	
	public String getSIDClientService() throws IOException{
		String SIDClientService = getPropertiesFileValue("SIDClientService");
		return SIDClientService;
	}

	public String getPasswordClientService() throws IOException{
		String PasswordClientService = getPropertiesFileValue("PasswordClientService");
		return PasswordClientService;
	}

	//Client Service Approver login information	
		public String getSIDPrimaryApprover() throws IOException{
			String SIDPrimaryApprover = getPropertiesFileValue("SIDPrimaryApprover");
			return SIDPrimaryApprover;
		}

		public String getPasswordPrimaryApprover() throws IOException{
			String PasswordPrimaryApprover = getPropertiesFileValue("PasswordPrimaryApprover");
			return PasswordPrimaryApprover;
		}
	//Client Service Approver for Structured login information	
		public String getSIDFistBackupApprover() throws IOException{
			String SIDFirstBackupApprover = getPropertiesFileValue("SIDFirstBackupApprover");
			return SIDFirstBackupApprover;
		}

		public String getPasswordFirstBackupApprover() throws IOException{
			String PasswordFirstBackupApprover = getPropertiesFileValue("PasswordFirstBackupApprover");
			return PasswordFirstBackupApprover;
		}
	//Client Service Approver for 3rd Party
		public String getSIDSecondBackupApprover() throws IOException{
			String SIDSecondBackupApprover = getPropertiesFileValue("SIDSecondBackupApprover");
			return SIDSecondBackupApprover;
		}

		public String getPasswordSecondBackupApprover() throws IOException{
			String PasswordSecondBackupApprover = getPropertiesFileValue("PasswordSecondBackupApprover");
			return PasswordSecondBackupApprover;
		}		
	//First Credit Team Approver login information
		public String getSIDFirstCreditTeamApprover() throws IOException{
			String SIDFirstCreditTeamApprover = getPropertiesFileValue("SIDFirstCreditTeamApprover");
			return SIDFirstCreditTeamApprover;
		}

		public String getPasswordFirstCreditTeamApprover() throws IOException{
			String PasswordFirstCreditTeamApprover = getPropertiesFileValue("PasswordFirstCreditTeamApprover");
			return PasswordFirstCreditTeamApprover;
		}
	//Second Credit Team Approve login information
		public String getSIDSecondCreditTeamApprover() throws IOException{
			String SIDSecondCreditTeamApprover = getPropertiesFileValue("SIDSecondCreditTeamApprover");
			return SIDSecondCreditTeamApprover;
		}

		public String getPasswordSecondCreditTeamApprover() throws IOException{
			String PasswordSecondCreditTeamApprover = getPropertiesFileValue("PasswordSecondCreditTeamApprover");
			return PasswordSecondCreditTeamApprover;
		}
}
