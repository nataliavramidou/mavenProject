package Facade;

import java.io.File;
import java.util.List;  
/**
 * The class MyFacade participates in the facade pattern.
 * it declares three methods (readSourceCode, calculateMetrics and write CSV) 
 * that can be accessed by the main class DesignPatterns
 * @author natalia
 *
 */

public  class MyFacade {
	private List<String> fileLines = null;
	private int[] metrics = null;
	
	public void setLines(List<String> lines) {
		this.fileLines =lines;
	}
	
	public List<String> getLines() {
		return fileLines;
	}
	
	public void setMetrics(int[] metrics) {
		this.metrics = metrics;
	}
	
	public int[] getMetrics() {
		return metrics;
	}
	
	/*
	 * the readSourceCode method takes an argument of type File
	 * and calls the readFile method of the MyUtility class,
	 * and then saves the result of the readFile method
	 * in the private parameter fileLines
	 */
	public void readSourceCode(File file) {
		List <String> temp = utility.MyUtility.readFile(file);
		this.setLines(temp);
	}

	/*
	 * the calculateMetrics method takes an argument of type String
	 * that declares the analyzing method and then
	 * calls the method createStrategy of the class MyFactory
	 * and saves the result of this method in the private parameter metrics
	 */
	public void calculateMetrics(String method) {
		Factory.MyFactory obj = new Factory.MyFactory();
		int[] metrics = obj.createStrategy(method, this.getLines());
		this.setMetrics(metrics);
	}
	
	/*
	 * the write CSV method calls the method writeFile of the class
	 * MyUtility and as a result provides a CSV file with the metrics
	 * of the java file that has been analyzed
	 */
	public void writeCSV () {
		utility.MyUtility.writeFile(this.getMetrics());
	}
	

}
