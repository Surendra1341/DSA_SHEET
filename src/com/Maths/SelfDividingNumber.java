package com.Maths;

import java.util.ArrayList;
import java.util.List;
/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.
Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).

Example 1:

Input: left = 1, right = 22
Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 */

class SelfDividingNumber {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkDividing(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean checkDividing(int n) {
        int value=n;
        while (n != 0) {
            int digit = n % 10;
            if (digit == 0 || value % digit != 0) return false;
            n /= 10;
        }
        return true;
    }
}