package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    MyMath mm = new MyMath();

    @Test
    public void test_factorial_negative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n must be between 0 and 12");
        mm.factorial(-5);
    }

    @Test
    public void test_factorial_aboveUpperBound() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n must be between 0 and 12");
        mm.factorial(13);
    }

    @Test
    public void test_isPrime_belowLimit() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be larger than 2");
        mm.isPrime(1);
    }

    @Test
    public void test_isPrime_prime() {
        Assert.assertTrue(mm.isPrime(97));
    }

    @Test
    public void test_isPrime_notPrime() {
        Assert.assertFalse(mm.isPrime(99));
    }

    @Test
    public void test_isPrime_two() {
        Assert.assertTrue(mm.isPrime(2));
    }

}
