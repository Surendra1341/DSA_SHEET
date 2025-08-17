package com.Recursion.easy;

public class Reverse_recursion {

    // method 01
    static int sum = 0;

    static void reverse1(int n) {
        if (n == 0) {
            return;
        }
        int r = n % 10;
        sum = sum * 10 + r;
        reverse1(n / 10);
    }
// method 2
    static int reverse2(int n) {
        int digit = (int) (Math.log10(n) + 1);
        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if (n % 10 == n) {
            return n;
        }
        int r = n % 10;
        return r * (int) (Math.pow(10, digit - 1)) + helper(n / 10, digit - 1);
    }

    public static void main(String[] args) {
// reverse1(1234);
// System.out.println(sum);
        System.out.println(reverse2(1002));
    }

}
