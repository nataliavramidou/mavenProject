package analyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegexAnalyzer participates in the strategy pattern.
 * it extends abstract class Analyzer.
 * it analyzes a java file by using regular expressions
 * to find out the number of lines of code (comments excluded),
 * the number of classes and the number of methods
 * that are included in a file
 * @author natalia
 * 
 */

public class RegexAnalyzer extends Analyzer {
	private List<String> list;
	
	public RegexAnalyzer (List<String> list) {
		this.list = list;
	}
	
	public List<String> getList() {
		return this.list;
	}
	
	/**
	 * the analyzeFile method analyzes a List of Strings to calculate the number of lines of code (loc)
	 * the number of classes(noc) and the number of methods (moc) of this list and returns an array with this metrics.
	 */
	public int[] analyzeFile() {
		int loc = 0; //lines of code
		int noc = 0; //number of classes
		int nom = 0; //number of methods
		int[] metricsArray = new int[3]; 
		
		List <String> lines = this.getList();
		
		String pattern_comment = "^\\s\\*|^/|^\t\\s\\*(.*)|^\\s/(.*)|^$|^\\s*$";
		String pattern_class = "(.*). class .(.*)";
		String pattern_method = "(.*)(public|private)(.*)(void|String|int|void|float|double|List|long)(.*)\\((.*)\\)\\s\\{";
		
		Pattern comment = Pattern.compile(pattern_comment);
		Pattern classes = Pattern.compile(pattern_class);
		Pattern method = Pattern.compile(pattern_method);		
		
		int count_nocode = 0;
		for (int i = 0; i < lines.size(); i++) {
			Matcher matcher = comment.matcher(lines.get(i));			
		      if (matcher.find( )) {
		    	  count_nocode ++;
		      }
		}
		
		loc = lines.size() - count_nocode;
		
		for (int i = 0; i < lines.size(); i++) {
			Matcher matcher = classes.matcher(lines.get(i));	
			Matcher matcher2 = comment.matcher(lines.get(i));
		    if (matcher.find( )) {
		    	if (!matcher2.find( )) {
			    	noc ++;
		    	}
		    }
		}
		
		for (int i = 0; i < lines.size(); i++) {
			Matcher matcher = method.matcher(lines.get(i));			
		    if (matcher.find( )) {
		    	nom ++;		 
		     }
		}	
		
		metricsArray[0] = loc;
		metricsArray[1] = noc;
		metricsArray[2] = nom;
		
		
		return metricsArray;
	}
}