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
* Create SourceFileReaderFactory factory class used for creating new exporter objects according to the Factory pattern.