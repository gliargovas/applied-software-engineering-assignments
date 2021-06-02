package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CodeAnalyzerFacade {

    public void readFilesAndExportMetrics(String sourceFileLocation, String filepath, String sourceCodeAnalyzerType,
                                          String outputFileType, String outputFilePath) throws IOException {

        SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();

        SourceFileReader reader = readerFactory.createSourceFileReader(sourceFileLocation);

        SourceCodeAnalyzerFactory codeAnalyzerFactory = new SourceCodeAnalyzerFactory();

        SourceCodeAnalyzer analyzer = codeAnalyzerFactory.createSourceCodeAnalyzer(sourceCodeAnalyzerType, reader);

        int loc = analyzer.calculateLOC(filepath);
        int nom = analyzer.calculateNOM(filepath);
        int noc = analyzer.calculateNOC(filepath);

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExporterFactory metricsExporterFactory = new MetricsExporterFactory();

        MetricsExporter exporter = metricsExporterFactory.createMetricsExporter(outputFileType);
        exporter.writeFile(metrics, outputFilePath);
    }

}
