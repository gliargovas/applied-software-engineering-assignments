package demo;

import codeanalyzer.CodeAnalyzerFacade;

import java.io.IOException;

public class DemoClient {

	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		System.out.println(args.length);
		if (args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		CodeAnalyzerFacade codeAnalyzer = new CodeAnalyzerFacade();
		codeAnalyzer.readFilesAndExportMetrics(sourceFileLocation, filepath, sourceCodeAnalyzerType,
				outputFileType, outputFilePath);
	}

}