package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class SourceCodeAnalyzerFactoryTest {

    SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();
    SourceFileReader mockedWebReader = mock(LocalFileReader.class);
    SourceFileReader mockedLocalReader = mock(LocalFileReader.class);


    @Test
    public void TestCreateSourceCodeAnalyzerRegexLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("regex", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof RegexAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerStringLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("strcomp", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof StringAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerNullLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("unknown", mockedLocalReader);
        Assert.assertTrue(analyzer instanceof NullAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerRegexWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("regex", mockedWebReader);
        Assert.assertTrue(analyzer instanceof RegexAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerStringWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("strcomp", mockedWebReader);
        Assert.assertTrue(analyzer instanceof StringAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerNullWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer analyzer = factory.createSourceCodeAnalyzer("unknown", mockedWebReader);
        Assert.assertTrue(analyzer instanceof NullAnalyzer);
    }
}
