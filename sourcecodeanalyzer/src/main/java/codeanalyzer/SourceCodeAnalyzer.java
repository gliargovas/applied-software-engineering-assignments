package codeanalyzer;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and
 * strcomp (with the use of string comparison).
 * This class deliberately contains code smells and violations of design principles.
 *
 * @author agkortzis
 */
public abstract class SourceCodeAnalyzer {
    protected SourceFileReader readerType;

    public SourceCodeAnalyzer(SourceFileReader readerType) {
        this.readerType = readerType;
    }

    public abstract int calculateLOC(String filepath) throws IOException;

    public abstract int calculateNOM(String filepath) throws IOException;

    public abstract int calculateNOC(String filepath) throws IOException;
}