package com.Funtions_04;

import java.util.Scanner;

public class Eligible {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("enter your age : ");
        int age=in.nextInt();
        criteria(age);
    }

    private static void criteria(int age) {
        if(age>18)
            System.out.println("eligibel");
        else
            System.out.println("not eligible");
    }
}
