package com.Conditionals_loops_03;

import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        System.out.println("factors are : ");
        for (int i=1;i<=a;i++){
            if(a%i==0){
                System.out.print(i+" ");
            }
        }

    }

}
