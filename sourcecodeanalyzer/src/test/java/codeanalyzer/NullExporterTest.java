package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

public class NullExporterTest {

    @Test
    public void testPrint() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        //redirect the System-output (normaly the console) to a variable
        System.setErr(new PrintStream(outContent));

        MetricsExporter mockedExporter = mock(NullExporter.class);
        // create an empty metrics content
        Map<String, Integer> metrics = new HashMap<>();
        String outputFilepath = "whatever-path";

        //this is a demo of how a mocked object can call a real method (partial mocking)
        doCallRealMethod().when(mockedExporter).writeFile(metrics, outputFilepath);
        mockedExporter.writeFile(metrics, outputFilepath);
        //check if your error message is in the output variable
        System.out.println(outContent.toString());
        File file = new File(outputFilepath.concat(".csv"));
        file.delete();
        Assert.assertEquals("Operation aborted due to unknown exporter type.\n", outContent.toString());
    }

}
