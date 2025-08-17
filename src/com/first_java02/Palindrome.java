package com.first_java02;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a= input.nextInt();
        int r=0;
        int s=a;

        while(a!=0){
            int b=a%10;
            r=r*10+b;
            a=a/10;
        }
        if (s==r)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
