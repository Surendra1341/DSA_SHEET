package com.Conditionals_loops_03;

import java.util.Scanner;

public class Averageofnumber {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("how many number you want to do average:");
        int n= input.nextInt();
        int s=0;
        for (int i=1;i<=n;i++){
            System.out.print("enter number"+i+" : ");
            int a= input.nextInt();
            s+=a;
        }
        float avg=(float) (s/n);
        System.out.println("average is : "+avg);
    }
}
