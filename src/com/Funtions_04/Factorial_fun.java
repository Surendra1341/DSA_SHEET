package com.Funtions_04;

import java.util.Scanner;

public class Factorial_fun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int n=fac(a);
        System.out.print(" !"+a+" is : "+n);
    }

    static int fac(int a) {
        if(a==0  ||  a==1){
            return 1;
        }

            return a*fac(a-1);

    }
}
