// Hackerrank task
package org.example;

import java.io.*;
import java.util.*;

public class CamelCase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*
            S;V;iPad -> i pad
            C;M;mouse pad -> mousePad()
            C;C;code swarm -> CodeSwarm
            S;C;OrangeHighlighter -> orange highlighter
        */

        //Scanner scan = new Scanner(System.in);

        //String camelCase = scan.nextLine();
        String camelCase = "C;C;iPad";

        String[] camelCaseSplit = camelCase.split(";");

        String firstLetter = camelCaseSplit[0];
        String secondLetter = camelCaseSplit[1];
        String name = camelCaseSplit[2];

        if(firstLetter.equals("S")){
            name = name.replaceAll("[^a-zA-Z]", "");
            name = name.replaceAll("([A-Z])", " $1").toLowerCase();
        }
        else if (firstLetter.equals("C")) {
            for (int i = 0; i < name.length(); i++){
                if(name.charAt(i) == ' '){
                    name = name.substring(0, i+1) + Character.toUpperCase(name.charAt(i+1)) + name.substring(i + 2);
                }
            }
            name = name.replaceAll(" ", "");

            if(secondLetter.equals("M")){ //Indicate Method
                name = name + "()";
            } else if(secondLetter.equals("C")){ //Indicate Class
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            }
        }
        System.out.println(name);
    }

}

