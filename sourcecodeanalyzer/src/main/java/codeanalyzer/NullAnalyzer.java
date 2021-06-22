package codeanalyzer;

import java.io.IOException;

public class NullAnalyzer extends SourceCodeAnalyzer {

    public NullAnalyzer(SourceFileReader readerType) {
        super(readerType);
    }

    public int calculateLOC(String filepath) {
        System.err.print("Operation aborted due to unknown analyzer type.\n");
        return 0;
    }

    public int calculateNOM(String filepath) throws IOException {
        System.err.print("Operation aborted due to unknown analyzer type.\n");
        return 0;
    }

    public int calculateNOC(String filepath) throws IOException {
        System.err.print("Operation aborted due to unknown analyzer type.\n");
        return 0;
    }
}
