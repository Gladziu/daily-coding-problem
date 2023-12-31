// #12 Problem
package org.example;

public class Staircase {
    /*There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N,
    write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

    For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

    What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number
    from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. */

    // DP solution O(N)
    static int countWays(int steps)
    {
        // declaring  two variables to store the count
        int prev = 1;
        int prev2 = 1;
        // Running for loop to count all possible ways
        for (int i = 2; i <= steps; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int steps = 5;
        System.out.println(countWays(steps));
    }


    // Recursive solution O(2^n)
    /*  static int fib(int n) {
            if (n <= 1)
                return n;
            return fib(n - 1) + fib(n - 2);
        }

        static int countWays(int s) {
            return fib(s + 1);
        } */
}
