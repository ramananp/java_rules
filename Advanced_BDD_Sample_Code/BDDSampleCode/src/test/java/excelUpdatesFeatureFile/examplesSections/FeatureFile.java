package excelUpdatesFeatureFile.examplesSections;

import java.util.HashMap;
import java.util.Map;
//Making the feature file an object makes it so that the different feature files 
//can have the same Scenario names and it does not cause an issue
public class FeatureFile {
	private String featureFileName = null;

	private Map<Integer, ScenarioOutline> scenarioMap = new HashMap<Integer, ScenarioOutline>();
	
	public String getFeatureFileName() {
		return featureFileName;
	}
	public void setFeatureFileName(String featureFileName) {
		this.featureFileName = featureFileName;
	}
	public Map<Integer, ScenarioOutline> getScenarioMap() {
		return scenarioMap;
	}
	public void setScenarioMap(Map<Integer, ScenarioOutline> scenarioMap) {
		this.scenarioMap = scenarioMap;
	}
}
