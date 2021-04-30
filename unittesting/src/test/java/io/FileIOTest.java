package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
    public static String resourcesPath = "src/test/resources/";
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    FileIO fileIO = new FileIO();

    public FileIOTest() {
    }

    @Test
    public void testReadFileValidInput() {
        int[] expectedNums = new int[]{12, 13, 7, -5, -9, 1, -9999};
        String validInputFilepath = resourcesPath.concat("nums_valid.txt");
        Assert.assertArrayEquals(expectedNums, this.fileIO.readFile(validInputFilepath));
    }

    @Test
    public void testReadFileEmptyInput() {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Given file is empty");
        this.fileIO.readFile(resourcesPath.concat("nums_empty.txt"));
    }

    @Test
    public void testReadFileNonExistent() {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Input file does not exist");
        this.fileIO.readFile(resourcesPath.concat("non_existent_file.txt"));
    }

    @Test
    public void testReadFileContainsInvalidEntries() {
        this.thrown.expect(NumberFormatException.class);
        this.fileIO.readFile(resourcesPath.concat("invalid_entries.txt"));
    }

    @Test
    public void testReadFileModifiedContainsInvalidEntries() {
        int[] expectedNums = new int[]{12, 13, 7, -5, -9, 1, -9999};
        String validInputFilepath = resourcesPath.concat("invalid_entries.txt");
        Assert.assertArrayEquals(expectedNums, this.fileIO.readFileModified(validInputFilepath));
    }
}