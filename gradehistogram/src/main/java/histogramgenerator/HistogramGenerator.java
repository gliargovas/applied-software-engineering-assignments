package histogramgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * The Histogram generator class.
 *
 * @author George Liargkovas
 * @version 1.0
 */
class HistogramGenerator {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HistogramGenerator h = new HistogramGenerator();
        if (args.length != 1) {
            System.err.println("Invalid number of arguments given!\n" +
                    "Expected only one: the filepath of the grades file ");
            System.exit(1);
        }
        int[] grades = h.scanGrades(args[0]);
        h.generateChart(grades);
    }

    /**
     * Scan grades the grades from a file and return them as an array.
     *
     * @param filepath the path of the grades file.
     * @return the int [ ] array with the grades.
     */
    public int[] scanGrades(String filepath) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> grades = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            grades.add(scanner.nextInt());
        }
        int[] gradeArray = new int[grades.size()];
        for (int i = 0; i < grades.size(); i++) {
            gradeArray[i] = grades.get(i);
        }
        return gradeArray;
    }

    /**
     * Generate chart.
     *
     * @param dataValues the data values
     */
    public void generateChart(int[] dataValues) {

        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries data = new XYSeries("Grades");


        for (int i = 0; i < dataValues.length; i++) {
            data.add(i, dataValues[i]);
        }

        // add the series to the dataset
        dataset.addSeries(data);

        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        // Declare and initialize a createXYLineChart JFreeChart
        JFreeChart chart = ChartFactory.createHistogram("Grades", "Student", "Grade", dataset,
                PlotOrientation.VERTICAL, legend, tooltips, urls);

        /*
         * Initialize a frame for visualizing the chart and attach the
         * previously created chart.
         */
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        // makes the previously created frame visible
        frame.setVisible(true);
    }
}