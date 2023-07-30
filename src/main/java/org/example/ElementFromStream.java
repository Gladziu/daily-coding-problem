// #15 Problem
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementFromStream {
    /* Given a stream of elements too large to store in memory,
    pick a random element from the stream with uniform probability. */

    static int count = 0;
    static int result = 0;
    public static int selectEelement(int x){
        Random random = new Random();
        count++;

        if(count == 1){
            result = x;
        }
        else {
            int i = random.nextInt(count);
            if (i == count-1){
                result = x;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> stream = new ArrayList<>();
        stream.add(1);
        stream.add(2);
        stream.add(3);
        stream.add(4);
        stream.add(7);
        stream.add(4);

        for (int number : stream){
            System.out.println("Random number from stream:" + selectEelement(number));
        }
    }
}
