// #1 Problem
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListAddition {
    public static void main(String[] args) {

        int k = 17;

        int[] listOfNumbers = {20, 14, 9, 10, 15, 3, 7, 15, 3, 7, 10, 15, 3, 7, 15, 1,  3, 7, 2};
        listOfNumbers = Arrays.stream(listOfNumbers).sorted().distinct().toArray();
        System.out.println(Arrays.toString(listOfNumbers));

        for (int i = 0; i < (listOfNumbers.length + 1) / 2; i++){
            for (int j = 0; j < listOfNumbers.length; j++){
                if (listOfNumbers[i] + listOfNumbers[j] == k){
                    int sum1 = listOfNumbers[i];
                    int sum2 = listOfNumbers[j];
                    System.out.println(sum1 + "+" + sum2 + "=" + k);

                }
            }
        }

        System.out.println();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(20, 14, 9, 10, 15, 3, 7, 15, 3, 7, 10, 15, 3, 7, 15, 1,  3, 7, 2));
        numbers = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(numbers);

        for (int i = 0; i < (numbers.size() + 1) / 2; i++){
            for (Integer number : numbers) {
                if (numbers.get(i) + number == k) {
                    int sum1 = numbers.get(i);
                    int sum2 = number;
                    System.out.println(sum1 + "+" + sum2 + "=" + k);
                }
            }
        }
    }
}