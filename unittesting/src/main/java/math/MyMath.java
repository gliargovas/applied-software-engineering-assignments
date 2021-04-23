package math;

/**
 * The class My math.
 *
 * @author George Liargkovas
 * @version 1.0
 */
public class MyMath {

    /**
     * Factorial int.
     *
     * @param n the number of which to calculate the factorial
     * @return the factorial of n
     * @throws IllegalArgumentException when <b>n</b> not between 0 and 12.
     */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("n must be between 0 and 12");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
