package com.Conditionals_loops_03;

import java.util.Scanner;

public class Infinitesum {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int s=0;
        System.out.println("enter the numbers you want add and then enter o for sum ::");
        while (true)
        {
            int a= input.nextInt();
            if(a==0){
                break;
            }
            else{
                s+=a;
            }
        }
        System.out.println("sum is :"+s);
    }
}
