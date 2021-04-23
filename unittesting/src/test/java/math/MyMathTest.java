package math;

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
}
