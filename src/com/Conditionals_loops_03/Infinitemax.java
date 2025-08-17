package com.Conditionals_loops_03;

import java.util.Scanner;

public class Infinitemax {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int max=0;
        while (true) {
            int a = input.nextInt();

            if (a == 0) {
                break;
            } else if (a > max) {
                max = a;
            }
        }
        System.out.println("maximum is : "+max);
    }
}
