package com.Maths;

public class Odd_even_bit {
    public static void main(String[] args) {
        int n=66;
        System.out.println(isodd(n));
    }

    private static boolean isodd(int n) {
         return (n&1)==1;
    }
}
