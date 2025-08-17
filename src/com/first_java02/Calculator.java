package com.first_java02;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
/*
    package com.company;

import java.util.Scanner;


    public class calculatoe {
//        public static void main(String[] args) {
//*/
        Scanner input = new Scanner(System.in);

        int ans = 0;
        while (true) {
            System.out.print("enter any operator : ");
            char op = input.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                System.out.print("enter two number: ");
                int a = input.nextInt();
                int b = input.nextInt();
                if (op == '+')
                    ans = a + b;
                if (op == '-')
                    ans = a - b;
                if (op == '*')
                    ans = a * b;
                if (op == '/') {
                    if (b != 0)
                        ans = (a / b);
                }

                if (op == '%')
                    ans = a % b;

            } else if (op == 'x' || op == 'X') break;
            else {
                System.out.println("invalid operator");
            }
            System.out.println("your answer is : "+ans);
        }
    }
}