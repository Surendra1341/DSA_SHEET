package com.first_java02;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a= input.nextInt();
        int count=0,s=0;
        int b=a;
        int x=b;
        while (a!=0){
            a=a/10;
            count++;
        }
        while (b!=0) {
            int c = b % 10;
            s +=(int) Math.pow(c,count);
            b=b/10;
        }
        if(s==x)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
