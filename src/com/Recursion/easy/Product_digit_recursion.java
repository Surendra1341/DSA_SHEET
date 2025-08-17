package com.Recursion.easy;

public class Product_digit_recursion {
    public static void main(String[] args) {

        System.out.println(digit(1234));
    }
    static int digit(int n) {
        if(n==0){
            return 1;
        }
        return (n%10) * digit(n/10);
    }
}
