package patterns;

import java.io.File; 

/**
 * Class DesignPatterns is the main class of the application
 * It takes two arguments from the terminal: the path of a java file
 * and the word "string" or "regex" to specify the method for analyzing the java file
 * @author natalia
 *
 */

public class DesignPatterns {
	
	public static void main(String[] args) {
		
		File file = null;
		String method = null;
		if (1 < args.length) {
			file = new File(args[0]);
			method = args[1];
		} else {
			 System.err.println("Invalid arguments count:" + args.length);
	    }
		
		AccessToFunctionalities obj = new AccessToFunctionalities();
		obj.readSourceCode(file);
		obj.calculateMetrics(method);
		obj.writeCSV();
	}

}
