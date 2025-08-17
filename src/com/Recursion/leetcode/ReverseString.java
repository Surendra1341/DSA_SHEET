package com.Recursion.leetcode;

import java.util.Arrays;
/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

class ReverseString {
    public static void main(String[] args) {
        char[] s={'a','b','c','d','e'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
         helper(s,0,s.length-1);
    }

    private static void helper(char[] s, int start, int end) {
        if(start>=end) return;

        swap(s,start,end);
        helper(s,start+1,end-1);
    }

    private static void swap(char[] s,int i,int j) {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}