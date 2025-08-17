package com.Conditionals_loops_03;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int fac=1;
        for(int i=1;i<=a;i++)

        {
            fac*=i;
        }
        System.out.println("factorial is : "+fac);
    }
}
