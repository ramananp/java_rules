package excelUpdatesFeatureFile.examplesSections;

import java.util.ArrayList;
import java.util.List;

//This stores the different scenario outlines called out in the excel file
//And each scenario outline has a series of rows associated with it

public class ScenarioOutline {
	
	private String scenarioOutline = "Scenario Outline:";
	private List<ExamplesRow> rows = new ArrayList<ExamplesRow>();

	public String getScenarioOutline() {
		return scenarioOutline;
	}

	public void setScenarioOutline(String scenarioOutline) {
		this.scenarioOutline = "Scenario Outline: " + scenarioOutline;
	}

	public List<ExamplesRow> getRows() {
		return rows;
	}

	public void setRows(List<ExamplesRow> rows) {
		this.rows = rows;
	}
	
	public void resetRows(){
		this.rows = null;
	}
}
