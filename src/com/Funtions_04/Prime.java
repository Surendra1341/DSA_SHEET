package com.Funtions_04;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(test(a));
    }

     static boolean test(int a) {
        if (a == 0 || a == 1) {
            return false;
        }
        int c = 2;
        while (c * c <= a) {
            if (a % c == 0)
                return false;
            c++;
           }
        return c * c > a;
    }
}