package com.Conditionals_loops_03;

import java.util.Scanner;

public class HCF_and_LCM {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("enter first number :");
        int a= input.nextInt();
        System.out.print("enter second number : ");
        int b= input.nextInt();
        int x=a,y=b;
        while(b!=0){
            int r=b;
            b=a%b;
            a=r;
        }
        System.out.println("HCF is : "+a);
        System.out.println("LCM is : "+(x*y)/a);




    }
}
