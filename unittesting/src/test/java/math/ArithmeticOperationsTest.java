package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    ArithmeticOperations ao = new ArithmeticOperations();

    @Test
    public void test_divide_positive() {
        Assert.assertEquals(2.0, ao.divide(4, 2), 0);
    }

    @Test
    public void test_divide_negative() {
        Assert.assertEquals(-2.0, ao.divide(-4, 2), 0);
    }

    @Test
    public void test_divide_bothNegative() {
        Assert.assertEquals(2.0, ao.divide(-4, -2), 0);
    }

    @Test
    public void test_divide_zeroNumerator() {
        Assert.assertEquals(0, ao.divide(0, -2), 0);
    }

    @Test
    public void test_multiply_positive() {
        Assert.assertEquals(16, ao.multiply(4, 4));
    }

    @Test
    public void test_multiply_zero() {
        Assert.assertEquals(0, ao.multiply(0, 4));
    }

    @Test
    public void test_multiply_maxBorder() {
        Assert.assertEquals(Integer.MAX_VALUE, ao.multiply(Integer.MAX_VALUE, 1));
    }

    @Test(expected = ArithmeticException.class)
    public void test_divide_zeroDenominator() {
        ao.divide(5, 0);
    }

    @Test
    public void test_multiply_outOfBounds() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        ao.multiply(Integer.MAX_VALUE, 10);
    }

    @Test
    public void test_multiply_negative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        ao.multiply(-2, 10);
    }


}
