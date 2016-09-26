package utilityPrograms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunGiftMeanValueBatch {
	
	public static void main (String args[]) throws IOException, InterruptedException {
		RunGiftMeanValueBatch batch = new RunGiftMeanValueBatch();
		batch.ExecuteMeanValueBatch();
	}
	
	//You would need to build and unzip the batch in the C:/FAST/AATAGiftMeanValueBatch/ file for this to work
	public void ExecuteMeanValueBatch() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("java", "-jar", "C:/FAST/AATAGiftMeanValueBatch/AATAGiftMeanValueBatch-7.04-SNAPSHOT.jar", "C:/FAST/AATAGiftMeanValueBatch/Config_SIT.properties");
		Process p = builder.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String s = "";
		while((s = in.readLine()) != null){
		    System.out.println(s);
		}
		int status = p.waitFor();
		System.out.println("Exited with status: " + status);
	}
}