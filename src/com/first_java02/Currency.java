package com.first_java02;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int r= input.nextInt();
        float d=r/83.0f;
        System.out.println("in dollar "+String.format("%.2f",d)+"$");
    }
}
