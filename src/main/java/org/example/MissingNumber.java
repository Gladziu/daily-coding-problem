// #4 Problem
package org.example;

import java.util.Arrays;

public class MissingNumber {
    public static int findMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Move all positive numbers to the left side of the array
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }


        // Step 2: Find the first missing positive number
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: All numbers from 1 to n are present, so the missing number is n + 1
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 14, 1, 1, 0, 4, -1, 1, 1 , -1, 2};
        int missing1 = findMissingPositive(nums1);
        System.out.println("Missing positive in "+ Arrays.toString(nums1) + ": " + missing1);

        int[] nums2 = {1, 2, 0};
        int missing2 = findMissingPositive(nums2);
        System.out.println("Missing positive in "+ Arrays.toString(nums2) + ": " + missing2);
    }
}