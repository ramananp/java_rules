package excelUpdatesFeatureFile;
//The purpose of this file is references the classes that update the feature files, property files, and excel
//You only have to excute this file to update everything.

import java.io.File;

import org.apache.commons.io.FileUtils;

import excelUpdatesFeatureFile.backgroundSection.UpdateAllPropertyFiles;
import excelUpdatesFeatureFile.examplesSections.ExcelFeatureMapper;
import excelUpdatesFeatureFile.excelFeatureTabList.UpdateExcelFeatureList;

public class UpdateEverything {

	public static void main(String[] args) throws Exception {
//Update Feature File Examples Sections
		ExcelFeatureMapper.main(args);
//Update the Excel Document
		UpdateExcelFeatureList.main(args);
//Update property files used in background
		UpdateAllPropertyFiles.main(args);
		System.out.println();
		System.out.println("**********************************All Property Files Are Updated*********************************");
		
	}
}
