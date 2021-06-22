package codeanalyzer;

public class SourceFileReaderFactory {
    public SourceFileReader createSourceFileReader(String location) {
        SourceFileReader reader;
        if (location.equals("local")) {
            reader = new LocalFileReader();
        } else if (location.equals("web")) {
            reader = new WebFileReader();
        } else {
            reader = new NullReader();
        }
        return reader;
    }
}
