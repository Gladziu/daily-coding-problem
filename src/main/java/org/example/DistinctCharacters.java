// #13 Problem
package org.example;

import java.util.HashMap;

public class DistinctCharacters {
    /* Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

    For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb". */

    public static void main(String[] args) {
        int result = findDistinct("abcttty", 2);
        System.out.println(result);
    }

    public static int findDistinct(String word, int difference){
        // Base case
        if (word == null || word.length() == 0 || difference <= 0){
            return 0;
        }

        HashMap<Character, Integer> charFrequency = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > difference) {
                char leftChar = word.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
