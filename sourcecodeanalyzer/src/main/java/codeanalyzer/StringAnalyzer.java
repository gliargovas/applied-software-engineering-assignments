package codeanalyzer;

import java.io.IOException;
import java.util.List;

public class StringAnalyzer extends SourceCodeAnalyzer {

    public StringAnalyzer(SourceFileReader readerType) {
        super(readerType);
    }

    public int calculateLOC(String filepath) throws IOException {
        List<String> sourceCodeList = readerType.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    public int calculateNOM(String filepath) throws IOException {
        List<String> sourceCodeList = readerType.readFileIntoList(filepath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{"))
                methodCounter++;
        }
        return methodCounter;
    }

    public int calculateNOC(String filepath) throws IOException {
        List<String> sourceCodeList = readerType.readFileIntoList(filepath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
