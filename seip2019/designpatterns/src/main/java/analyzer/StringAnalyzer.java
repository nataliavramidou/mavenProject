package analyzer;

import java.util.List;

/**
 * Class StringAnalyzer participates in the strategy pattern.
 * it extends abstract class Analyzer.
 * it analyzes a java file using the method of string comparison
 * to find out the number of lines of code (comments excluded),
 * the number of classes and the number of methods
 * that are included in a file
 * @author natalia
 * 
 */
public class StringAnalyzer extends Analyzer {
	private List<String> fileLines;
	
	public StringAnalyzer (List<String> list) {
		this.fileLines = list;
	}
	
	public List<String> getList() {
		return this.fileLines;
	}
	
	/**
	 * the analyzeFile method analyzes a List of Strings to calculate the number of lines of code (loc)
	 * the number of classes(noc) and the number of methods (moc) of this list and returns an array with this metrics.
	 */
	public int[] analyzeFile() {
		int loc = 0; //lines of code
		int noc = 0; //number of classes
		int nom = 0; //number of methods
		
		int[] metrics = new int[3];
		
		List <String> lines = this.getList();
	        
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i).trim();
			if (!(line.startsWith("/") || line.startsWith("*") || line.isEmpty())) {
				loc++;
			} 
		}
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i).trim();
			if (line.contains("class") && (!(line.startsWith("/") || line.startsWith("*")))) {
				noc++;
			}
		}
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i).trim();
			if (line.startsWith("public") || line.startsWith("private"))  {
				if (line.contains("void") || line.contains("String") || line.contains("int") || line.contains("double") || line.contains("float") || line.contains("List") || line.contains("long")) {
					if (line.contains("(") && line.contains(")") && line.contains("{")) {
						nom++;
					}
				}
			}
		}		
		
		metrics[0] = loc;
		metrics[1] = noc;
		metrics[2] = nom;
		
		
		return metrics;
	}
}
