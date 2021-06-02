package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CodeAnalyzerFacadeTest {

    @Test
    public void TestReadFileAndExportMetrics() {
        String filepath = "src/main/resources/TestClass.java";
        String sourceCodeAnalyzerType = "regex";
        String sourceFileLocation = "local";
        String outputFilePath = "output_metrics";
        String outputFileType = "csv";

        CodeAnalyzerFacade codeAnalyzer = new CodeAnalyzerFacade();
        try {
            codeAnalyzer.readFilesAndExportMetrics(sourceFileLocation, filepath, sourceCodeAnalyzerType,
                    outputFileType, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outFile = new File(outputFilePath.concat(".").concat(outputFileType));
        Assert.assertTrue(outFile.exists());

        // delete the generated file
        outFile.delete();
    }
}
