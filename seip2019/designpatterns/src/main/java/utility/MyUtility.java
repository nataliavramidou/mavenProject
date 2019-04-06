package utility;

import java.util.ArrayList;
import java.util.List;  
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * Class MyUtility participates in the utility pattern
 * It includes the static method readFile for reading a file line by line and
 * the static method writeFile for creating a csv file with some metrics.
 * @author natalia
 * 
 */

public final class MyUtility {
	
	/*
	 *  the readfile method takes an argument of type File
	 *  reads the file line by line 
	 *  and adds each line in a List of type String
	 */
	public static List<String> readFile(File file) {
		List<String> lines = new ArrayList<String>(); 
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));  
			for(String line; (line = br.readLine()) != null; ) {
				lines.add(line);
			}
			br.close();
		} catch (IOException e) {
            e.printStackTrace();
        } 
		return lines;
	}
	
	/*
	 * the writeFile method takes as an argument an array of int values
	 * that represent the metrics lines of code, number of classes and number of methods
	 * and creates a csv file with this metrics.
	 */
	public static void writeFile(int[] metrics) {
		
		try {
			PrintWriter writer = new PrintWriter(new File("metrics.csv"));

		      StringBuilder sb = new StringBuilder();
		      sb.append("Metric");
		      sb.append(',');
		      sb.append("Value");
		      sb.append('\n');
		      
		      sb.append("Lines of Code");
		      sb.append(',');
		      sb.append(Integer.toString(metrics[0]));
		      sb.append('\n');
		      
		      sb.append("Number of Classes");
		      sb.append(',');
		      sb.append(Integer.toString(metrics[1]));
		      sb.append('\n');
		      
		      sb.append("Number of Methods");
		      sb.append(',');
		      sb.append(Integer.toString(metrics[2]));
		      sb.append('\n');
		      

		     writer.write(sb.toString());
		      writer.close();

		    } catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		    }

	}
}
