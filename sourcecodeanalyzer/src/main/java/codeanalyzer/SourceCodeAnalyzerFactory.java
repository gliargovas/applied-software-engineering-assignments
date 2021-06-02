package codeanalyzer;

public class SourceCodeAnalyzerFactory {
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String readerType, SourceFileReader location) {
        SourceCodeAnalyzer analyzer;
        if (readerType.equals("regex")) {
            analyzer = new RegexAnalyzer(location);
        } else if (readerType.equals("strcomp")) {
            analyzer = new StringAnalyzer(location);
        } else {
            analyzer = new NullAnalyzer(location);
        }
        return analyzer;
    }
}
