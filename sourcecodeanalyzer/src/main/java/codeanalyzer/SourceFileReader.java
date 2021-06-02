package codeanalyzer;

import java.io.IOException;
import java.util.List;

public interface SourceFileReader {

    List<String> readFileIntoList(String filepath) throws IOException;

    String readFileIntoString(String filepath) throws IOException;
}
