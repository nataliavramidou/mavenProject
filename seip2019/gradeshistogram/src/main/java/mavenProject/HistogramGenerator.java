package mavenProject;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class HistogramGenerator {

	public int[] readGrades(File file) {
		int[] frequencies = new int[11];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String currentLine;
			int grade;
			while ((currentLine = br.readLine()) != null) {
				grade = Integer.parseInt(currentLine);
				frequencies[grade] = frequencies[grade] + 1;
			}
		br.close();
		

		} catch (IOException e) {
            e.printStackTrace();
        } 
		return frequencies;
	}
	
	public void generateChart(int[] frequencies) {

		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries data = new XYSeries("values");

		for (int i = 0; i < frequencies.length; i++) {
			data.add(i, frequencies[i]);
		}

		dataset.addSeries(data);

		boolean legend = false; 
		boolean tooltips = false; 
		boolean urls = false; 

		JFreeChart chart = ChartFactory.createXYLineChart("Histogram", "Grades", "Values", dataset,
						PlotOrientation.VERTICAL, legend, tooltips, urls);

				ChartFrame frame = new ChartFrame("First", chart);
				frame.pack();
				frame.setVisible(true);
	   }
	
	
	public static void main(String[] args) {
		
		File file = null;
		if (0 < args.length) {
			file = new File(args[0]);
		} else {
			 System.err.println("Invalid arguments count:" + args.length);
	    }
		
		HistogramGenerator obj = new HistogramGenerator();
		int[] grades = obj.readGrades(file);
		obj.generateChart(grades);
		
	}

}
