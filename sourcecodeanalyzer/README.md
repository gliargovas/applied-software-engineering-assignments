Refactor MetricsExporter class

Refactor MetricsExporter in order to follow the Strategy pattern combined with the Factory pattern and the Null object
pattern:

* Make MetricsExporter an interface.
* Create JsonExporter, CsvExporter and NullExporter (satisfies Null Object pattern) and implement MetricsExporter old
  functionality, following the strategy pattern.
* Create MetricsExporter factory used for creating new exporter objects according to the Factory pattern.

Refactor SourceFileReader class

Refactor SourceFileReader in order to follow the Strategy pattern combined with the Factory pattern and the Null object
pattern:

* Make SourceFileReader an interface.
* Create WebFileReader, LocalFileReader and NullReader (satisfies Null Object pattern) and implement SourceFileReader
  old functionality, following the strategy pattern.
* Create SourceFileReaderFactory factory class used for creating new reader objects according to the Factory pattern.

Refactor SourceCodeAnalyzer class

Refactor SourceCodeAnalyzer in order to follow the Bridge pattern combined with the Factory pattern and the Null object
pattern:

* Make SourceCodeAnalyzer an abstract class (Bridge Pattern).
* Create StringAnalyzer, RegexAnalyzer and NullAnalyzer (satisfies Null Object pattern) classes that extend
  SourceCodeAnalyzer's functionality, following the Bridge pattern.
* Create SourceCodeAnalyzerFactory factory class used for creating new analyzer objects according to the Factory
  pattern.

Create CodeAnalyzerFacade class

Utilize the Facade Pattern by creating CodeAnalyzerFacade class that offers the core functionality of code analyzer
while hiding the module implementation from the client. The class contains the readFilesAndExportMetrics method that
implements all the functionality, previously called individually by the client.



