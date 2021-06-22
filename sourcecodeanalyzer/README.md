## Execution Instructions

1. Build the executable Java application with:
   `mvn package jacoco:report`

2. Run the executable by executing `java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4` were args translate to:

arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
   
arg1 = “sourceCodeAnalyzerType” \[regex|strcomp]

arg2 = “SourceCodeLocationType” \[local|web]

arg3 = “OutputFilePath” (e.g., ../output_metrics_file)

arg4 = “OutputFileType” \[csv|json]

**Example:**

        java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv

## Explanation of changes

In general, the patterns used in the project are the following:

1) Facade Pattern
2) Strategy Pattern
3) Factory Pattern
4) Null Object Pattern

In most occasions a combination of those patterns is used. Below follows an explanation of each change:

### CodeAnalyzerFacade.java:

Utilize the Facade Pattern by creating CodeAnalyzerFacade class that offers the core functionality of code analyzer
while hiding the module implementation from the client. The class contains the readFilesAndExportMetrics method that
implements all the functionality, previously called individually by the client.

**Pros of this approach:**

+ Simpler interface for the client
+ Decoupled subsystem and client
+ Layered subsystem (client <-> facade <-> functionality)

### MetricsExporter.java:

MetricsExporter was changed in order to follow the Strategy pattern combined with the Factory pattern and the Null
object pattern. For this reason, MetricsExporter was converted to an interface and three new classes, JsonExporter,
CsvExporter and NullExporter were created. Null Exporter also helps satisfy the Null object pattern.

The following steps were followed:

* Make MetricsExporter an interface.
* Create JsonExporter, CsvExporter and NullExporter (satisfies Null Object pattern) and implement MetricsExporter old
  functionality, following the strategy pattern.
* Create MetricsExporter factory used for creating new exporter objects according to the Factory pattern.

**Pros of this approach:**

+ Each class serves only one purpose whereas before MetricsExporter was previously used for extraction of many formats -
  Single responsibility principle (Strategy Pattern)
+ Exporters are now interchangeable and their functionality can be easily extended (Strategy Pattern, Factory Pattern)
+ Separation of concerns is satisfied (Factory Pattern)
+ No need for clients to handle null cases (Null Object)
+ Further simplified the facade code (Null Object)

**Cons of this approach:**

- Hidden errors (Null object)

### SourceFileReader.java:

Following a similar approach like above, SourceFileReader was changed in order to follow the Strategy pattern combined
with the Factory pattern and the Null object pattern. For this reason, SourceFileReader was converted to an interface
and three new classes, LocalFileReader, WebFileReader and NullReader were created. Null Exporter also helps satisfy the
Null object pattern

The following steps were followed:

* Make SourceFileReader an interface.
* Create WebFileReader, LocalFileReader and NullReader (satisfies Null Object pattern) and implement SourceFileReader
  old functionality, following the strategy pattern.
* Create SourceFileReaderFactory factory class used for creating new reader objects according to the Factory pattern.

### SourceCodeAnalyzer.java:

SourceCodeAnalyzer was changed in order to follow the Bridge pattern combined with the Factory pattern and the Null
object pattern. The Bridge pattern was chosen as SourceCodeAnalyzer used SourceFileReader to perform its operations.
Source file reader was highly coupled to SourceCode analyzer and had many implementations, so there was a need to
separate them:

The following steps were followed:

* Make SourceCodeAnalyzer an abstract class (Bridge Pattern).
* Create StringAnalyzer, RegexAnalyzer and NullAnalyzer (satisfies Null Object pattern) classes that extend
  SourceCodeAnalyzer's functionality, following the Bridge pattern.
* Create SourceCodeAnalyzerFactory factory class used for creating new analyzer objects according to the Factory
  pattern, that takes as an argument a SourceFileReader. So the bridge pattern was implemented with the use of
  SourceFileReader's factory class.

**Pros of this approach**:

+ SourceCodeAnalyzer and SourceFileReader are now independent. Changing the one does not need to change the other.
+ They are also both more easily extendable as minimal changes are needed when adding a nre SourceFileReader or changing
  the implementation of SourceCodeAnalyzer.
+ Separation of concerns is more clear now
+ The program can handle null cases

**Cons of this approach**:

+ Null objects may hide the errors
+ SourceCodeAnalyzer and SourceFileReader are still coupled, to a lesser extent as SourceFileReader is used in the
  Factory of SourceCodeAnalyzer.





