package com.Strings;

import java.util.Arrays;

/*
You are given a string s and an integer array indices of the same length.
        The string s will be shuffled such that the character at the ith position moves to indices[i]
        in the shuffled string.Return the shuffled string.

 */
public class Shuffle_string {
    public static void main(String[] args) {
        String s="codeleet";
        int[] arr={4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s,arr));
    }
    public static String restoreString(String s, int[] arr) {
        char[] ch=new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ch[arr[i]]=s.charAt(i);

        }
        return String.valueOf(ch);
    }
}
