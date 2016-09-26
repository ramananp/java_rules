package excelUpdatesFeatureFile.examplesSections;

import java.util.ArrayList;
import java.util.List;

//This stores each line that will be inserted for a given Scenario Outline
//Each line in the examples section is its own object

public class ExamplesRow {

	public List<String> columns = new ArrayList<String>();

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public String toString() {
		String columnsString = "|";
		for (String column : columns) {
			columnsString = columnsString + column + "|";
		}
		return columnsString;
	}
	
	public void resetColumns(){
		this.columns = null;
	}
}
