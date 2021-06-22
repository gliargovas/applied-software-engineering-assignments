package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class deliberately contains code smells and violations of design principles.
 *
 * @author agkortzis
 */
public interface MetricsExporter {
	void writeFile(Map<String, Integer> metrics, String filepath);
}
