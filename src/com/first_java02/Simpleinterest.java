package com.first_java02;

import java.util.Scanner;

public class Simpleinterest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int p = input.nextInt();
        int t = input.nextInt();
        float r = input.nextFloat();
        float si = (p * r * t) / 100.0f;
        System.out.println("simple intrest: "+si);

    }
}
