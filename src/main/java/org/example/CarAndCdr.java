package org.example;

import java.awt.*;

public class CarAndCdr {
     /*
        This problem was asked by Jane Street.

        cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns
        the first and last element of that pair. For example, car(cons(3, 4)) returns 3,
        and cdr(cons(3, 4)) returns 4.

        Given this implementation of cons:

        def cons(a, b):
            def pair(f):
                return f(a, b)
            return pair
        Implement car and cdr.
    */

     public static int[] cons(int a, int b){
         int[] returnOfValue = new int[2];

         returnOfValue[0] = a;
         returnOfValue[1] = b;

         return returnOfValue;
     }

    public static int car(int[] f){
        return f[0];
    }

    public static int cdr(int[] f){
        return f[f.length-1];
    }

     public static void main(String[] args) {
        int result = cdr(cons(3, 4));
        int result2 = car(cons(3, 4));
         System.out.println(result);
         System.out.println(result2);
     }
}
