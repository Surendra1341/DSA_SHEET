package com.Conditionals_loops_03;

import java.util.Scanner;

public class Perfect_numbers {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("enter any number : ");
        int a=input.nextInt();
        int s=0;

        for (int i=1;i<=a/2;i++){
            if(a%i==0){
                s+=i;
            }
        }
        if(s==a){
            System.out.println(a+" is perfect");

        }else{
            System.out.println(a+" is not");
        }
    }
}
