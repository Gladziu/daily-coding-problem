// #18 Probelm
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxValueOfSubarray {
    /* Given an array of integers and a number k, where 1 <= k <= length of the array,
    compute the maximum values of each subarray of length k.

    For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

    10 = max(10, 5, 2)
    7 = max(5, 2, 7)
    8 = max(2, 7, 8)
    8 = max(7, 8, 7)
    Do this in O(n) time and O(k) space. You can modify
    the input array in-place and you do not need to store the results.
    You can simply print them out as you compute them. */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 2, 7, 8, 7));
        int k = 3;

        maxValue(numbers, k);
    }

    static void maxValue(List<Integer> numbers, int k) {

        int numbersLen = numbers.size();

        if( k <= 0 || k > numbersLen) {
            System.out.println("Invalid value of k.");
            return;
        }

        if (k == 1){
            return;
        }

        int i;
        for (i = 0; i < (numbersLen - k + 1); i++) {
            int max = numbers.subList(i, i + k)
                    .stream()
                    .max(Integer::compareTo)
                    .get();
            numbers.set(i, max);
        }

        while (i < numbersLen){
            numbers.remove(numbers.size()-1);
            i++;
        }

        System.out.println(numbers);
    }
}



