package codeanalyzer;

public class MetricsExporterFactory {
    public MetricsExporter createMetricsExporter(String fileType) {
        MetricsExporter exporter;
        if (fileType.equals(("csv"))) {
            exporter = new CsvExporter();
        } else if (fileType.equals("json")) {
            exporter = new JsonExporter();
        } else {
            exporter = new NullExporter();
        }
        return exporter;
    }
}
