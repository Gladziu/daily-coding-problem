// #2 Problem
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipliedNumbers {
    /* Given an array of integers, return a new array such that each element at index i of
     the new array is the product of all the numbers in the original array except the one at i.
    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6]. */

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> clonedNumbers = new ArrayList<>();

        int multiplication = 1;

            for (int number : numbers){
                if (number==0){
                    continue;
                }
                multiplication = multiplication * number;
            }

            for (int number : numbers){
                if (number == 0){
                    clonedNumbers.add(0);
                    continue;
                }
                int finalNumber = multiplication / number;
                clonedNumbers.add(finalNumber);
            }

            System.out.println(clonedNumbers);
    }
}