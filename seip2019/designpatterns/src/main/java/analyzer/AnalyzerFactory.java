package analyzer;

import java.util.List;

/**
 * The class AnalyzerFactory participates in the factory pattern
 * It creates an Analyzer object to call the right implementation of 
 * the analyzeFile method (string or regex)
 * @author natalia
 *
 */

public class AnalyzerFactory {
	
	/*
	 * the method createAnalyzer takes as an argument a string that specifies the analyzing method
	 * and a list of Strings. it calls the right implementation of the method analyzeFile
	 * and creates an array with the metrics
	 */
	public int[] createAnalyzer(String method, List<String> list) {
		Analyzer str; 
		int[] metrics = null;
		
		if (method.equals("string")) {
			str = new StringAnalyzer(list);
			metrics = str.analyzeFile();
			
		} else if (method.equals("regex")) {
			str = new RegexAnalyzer(list);
			metrics = str.analyzeFile();
			
		}
		
		return metrics;
	}
}
