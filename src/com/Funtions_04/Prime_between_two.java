package com.Funtions_04;

import java.util.Scanner;

public class Prime_between_two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("input two numbers->");
        int a=in.nextInt();
        int b=in.nextInt();
        for(int i=a;i<=b;i++){
            if (prime(i)) {

                System.out.print(i+" ");
            }
        }

    }

    private static boolean  prime(int a) {
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

