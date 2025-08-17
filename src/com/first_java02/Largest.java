package com.first_java02;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a= input.nextInt();
        int b= input.nextInt();
        if(a>b) System.out.println(a+" is largest");
        else
            System.out.println("b is largest");
    }
}
