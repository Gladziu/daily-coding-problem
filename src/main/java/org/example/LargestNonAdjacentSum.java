// #9 Problem
package org.example;

import java.util.*;

public class LargestNonAdjacentSum {
    /*
    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
    */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 4, 6, 2, 5));
        Set<Integer> indexes = new HashSet<>();


        int index = 0;
        int sum = 0;

        while (numbers.size() != indexes.size()){
            int biggestNumber = 0;
            for (int i = 0; i < numbers.size(); i++){
                if (indexes.contains(i)){
                    continue;
                }
                if (numbers.get(i) > biggestNumber){
                    biggestNumber = numbers.get(i);
                    index = i;
                }
            }
            indexes.add(index);
            if (index!=0){
                indexes.add(index-1);
            }
            if (index!=(numbers.size()-1)){
                indexes.add(index+1);
            }
            sum+=biggestNumber;


        }
        System.out.println(sum);
        System.out.println(indexes);
    }
}
