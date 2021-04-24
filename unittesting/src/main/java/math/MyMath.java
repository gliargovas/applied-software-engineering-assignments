package math;

/**
 * Simple implementation of the calculation of a number's factorial that serves as hands-on practice on Unit Testing.
 *
 * @author George Liargkovas
 * @version 1.0
 * @since 2020-04-23
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
