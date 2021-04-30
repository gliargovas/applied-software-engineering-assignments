package math;

import io.FileIO;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayOperationsTest {
    ArrayOperations ao = new ArrayOperations();

    @Test
    public void test_find_primes_in_file_Mocking() {
        MyMath mm = mock(MyMath.class);
        when(mm.isPrime(2)).thenReturn(true);
        when(mm.isPrime(3)).thenReturn(true);
        when(mm.isPrime(4)).thenReturn(false);
        when(mm.isPrime(5)).thenReturn(true);
        when(mm.isPrime(6)).thenReturn(false);
        when(mm.isPrime(7)).thenReturn(true);
        when(mm.isPrime(8)).thenReturn(false);

        FileIO io = mock(FileIO.class);
        when(io.readFileModified("filepath")).thenReturn(new int[]{2, 3, 4, 5, 6, 7, 8});

        Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, ao.findPrimesInFile(io, "filepath", mm));
    }
}
