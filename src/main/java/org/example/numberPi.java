// #14 Problem
package org.example;

import java.util.Random;

public class numberPi {
    /* The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
    Hint: The basic equation of a circle is x2 + y2 = r2. */

    public static void main(String[] args) {
        int circlePoints = 0, squarePoints = 0;
        Random random = new Random();

        for (int i = 0; i < 1000; i++){
            double pointX = random.nextDouble() * 2 - 1;
            double pointY = random.nextDouble() * 2 - 1;

            double d = pointX * pointX + pointY * pointY;

            if (d <= 1){
                circlePoints++;
            }
            squarePoints++;
        }
        double pi = ((double) (4 * circlePoints) / squarePoints);
        System.out.println(pi);
    }
}
