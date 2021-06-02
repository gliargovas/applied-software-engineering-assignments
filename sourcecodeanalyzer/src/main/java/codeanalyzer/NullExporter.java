package codeanalyzer;

import java.util.Map;


public class NullExporter implements MetricsExporter {

    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        System.err.print("Operation aborted due to unknown exporter type.\n");
    }
}
