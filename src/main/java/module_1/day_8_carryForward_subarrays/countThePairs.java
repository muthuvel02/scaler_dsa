package module_1.day_8_carryForward_subarrays;

import java.util.Arrays;

//Count the pairs "ag"
// given a character array, calculate the number of pairs i,j such the i < j && s[i] = "a" && S[j]
import java.util.Arrays;

public class countThePairs {

    // Brute force solution: O(n^2) time complexity
    public static int countThePairsBruteForce(char[] array) {
        int countA = 0;  // Number of 'a' characters seen so far
        int countPairs = 0;  // Total count of 'a' -> 'g' pairs

        // Traverse the array from left to right
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a') {
                countA++;  // Increment 'a' count
            } else if (array[i] == 'g') {
                countPairs += countA;  // Add all previously seen 'a' to the count
            }
        }

        return countPairs;
    }
    // Prefix sum solution: O(n) time complexity
    public static int countThePairsPrefixSum(char[] array) {
        int n = array.length;
        int[] gCountAfter = new int[n];  // Array to store number of 'g's after each index

        // Build the prefix sum array from right to left
        gCountAfter[n - 1] = (array[n - 1] == 'g') ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            gCountAfter[i] = gCountAfter[i + 1] + ((array[i] == 'g') ? 1 : 0);
        }
        System.out.println(Arrays.toString(gCountAfter));

        // Traverse the array and count pairs
        int countPairs = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 'a') {
                countPairs += gCountAfter[i];  // Add the number of 'g's after this 'a'
            }
        }

        return countPairs;
    }

    // Optimized solution: O(n) time complexity
    public static int countThePairsOptimiseSolution(char[] array) {
        int countA = 0;
        int countPairs = 0;

        // Count 'a's and 'g's in a single pass
        for (char c : array) {
            if (c == 'a') {
                countA++;
            } else if (c == 'g') {
                countPairs += countA; // For each 'g', add the number of 'a's seen before it
            }
        }
        return countPairs;
    }

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'g', 'a', 'g', 'a', 'g'};

        System.out.println("countThePairsBruteForce: " + countThePairsBruteForce(array));
        System.out.println("countThePairsPrefixSum: " + countThePairsPrefixSum(array));
        System.out.println("countThePairsOptimiseSolution: " + countThePairsOptimiseSolution(array));
    }
}
