package codeanalyzer;

import java.util.List;

public class NullReader implements SourceFileReader {
    @Override
    public List<String> readFileIntoList(String filepath) {
        System.err.print("Operation aborted due to unknown source type.\n");
        return null;
    }

    @Override
    public String readFileIntoString(String filepath) {
        System.err.print("Operation aborted due to unknown source type.\n");
        return null;
    }
}
