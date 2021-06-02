package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterFactoryTest {

    MetricsExporterFactory factory = new MetricsExporterFactory();

    @Test
    public void testCreateMetricsExporterCsv() {
        MetricsExporter exporter = factory.createMetricsExporter("csv");
        Assert.assertTrue(exporter instanceof CsvExporter);
    }

    @Test
    public void testCreateMetricsExporterJson() {
        MetricsExporter exporter = factory.createMetricsExporter("json");
        Assert.assertTrue(exporter instanceof JsonExporter);
    }

    @Test
    public void testCreateMetricsExporterNull() {
        MetricsExporter exporter = factory.createMetricsExporter("invalid type");
        Assert.assertTrue(exporter instanceof NullExporter);
    }
}
