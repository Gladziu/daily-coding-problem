// #7 Problem
package org.example;

import java.util.ArrayList;

public class DecodeNumbers {

    /*
    This problem was asked by Facebook.

    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

    You can assume that the messages are decodable. For example, '001' is not allowed.
    */

    public static void main(String[] args){

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(1);

        for (int number : numbers){
            System.out.print((char)(number+96));
        }
        System.out.println();

        for (int i = 0; i < numbers.size(); i++){

            if (i + 2 > numbers.size()){
                System.out.print((char) (numbers.get(i) + 96));
                break;
            }

            int twoNumbersSum = numbers.get(i) * 10 + numbers.get(i+1);
            if (twoNumbersSum < 27){
                System.out.print((char) (twoNumbersSum+96));
            } else {
                System.out.print((char) (numbers.get(i)+96));
                System.out.print((char) (numbers.get(i + 1) + 96));

            }
            ++i;
        }
        System.out.println();

        System.out.print((char) (numbers.get(0)+96));
        for (int i = 1; i < numbers.size(); i++){

            if (i + 2 > numbers.size()){
                System.out.print((char) (numbers.get(i) + 96));
                break;
            }

            int twoNumbersSum = numbers.get(i) * 10 + numbers.get(i+1);
            if (twoNumbersSum < 27){
                System.out.print((char) (twoNumbersSum+96));
            } else {
                System.out.print((char) (numbers.get(i)+96));
                System.out.print((char) (numbers.get(i + 1) + 96));

            }
            ++i;
        }
    }
}
