package math;

import io.FileIO;

import java.util.ArrayList;

/**
 * The ArrayOperations provides simple array operations
 * that serve as hands-on practice on Unit Testing.
 *
 * @author gliargovas
 * @version 1.0
 * @since 2021-04-29
 */

public class ArrayOperations {

    /**
     * Performs the basic arithmetic operation of division.
     *
     * @param fileIo   a FileIO object
     * @param filepath the path of the file of which to read the numbers
     * @param myMath   a MyMath object
     * @return the result of the division between numerator and denominator
     * @throws IllegalArgumentException when a number less than 2 exists in the array
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] nums = fileIo.readFile(filepath);
        ArrayList<Integer> prime_nums = new ArrayList<Integer>();
        for (int num : nums) {
            if (myMath.isPrime(num)) {
                prime_nums.add(num);
            }
        }
        int[] primeNumArray = new int[prime_nums.size()];
        int i = 0;
        for (Integer num : prime_nums) {
            primeNumArray[i] = num;
            i++;
        }
        return primeNumArray;
    }
}
