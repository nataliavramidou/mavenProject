package Factory;

import java.util.List;

/**
 * The class MyFactory participates in the factory pattern
 * It creates a strategy object to call the right implementation of 
 * the analyzeFile method (string or regex)
 * @author natalia
 *
 */

public class MyFactory {
	
	/*
	 * the method createStrategy takes as an argument a string that specifies the analyzing method
	 * and a list of Strings. it calls the right implementation of the method analyzeFile
	 * and creates an array with the metrics
	 */
	public int[] createStrategy(String method, List<String> list) {
		strategy.MyStrategy str; 
		int[] metrics = null;
		
		if (method.equals("string")) {
			str = new strategy.StringAnalyzer(list);
			metrics = str.analyzeFile();
			
		} else if (method.equals("regex")) {
			str = new strategy.RegexAnalyzer(list);
			metrics = str.analyzeFile();
			
		}
		
		return metrics;
	}
}
