package com.Recursion.easy;

public class Palindrome_recursion {
    static int reverse2(int n) {
        int digit = (int) (Math.log10(n) + 1);   //length
        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if (n % 10 == n) {
            return n;
        }
        int r = n % 10;
        return r * (int) (Math.pow(10, digit - 1)) + helper(n / 10, digit - 1);
    }
    static boolean palindrome(int n){
        return (n==reverse2(n));
    }

    public static void main(String[] args) {

        System.out.println(palindrome(12321));
    }

}
