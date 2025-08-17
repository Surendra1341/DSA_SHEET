package com.Funtions_04;

import java.util.Scanner;

public class Maximum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter three number :");
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();

        Max(a,b,c);
    }

    private static void Max(int a, int b, int c) {
        int max=a;
        if(b>a){
            max=b;
            if(c>b)
                max=c;
        }else if(c>a) {
            max = c;
            if (b > c)
                max = b;
        }
        System.out.println(max);
    }
}
