package com.Conditionals_loops_03;

import java.util.Scanner;

public class Electricitybill {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter units :");
        int u= input.nextInt();
        double bill;
        if(u<=100) {
            bill=u*7;
        } else {
            if(u>=100 && u<=300)
                        bill = 7*100 + (u-100)*8;
                    else
                        bill = 7*100 + 8*200 + (u-300)*9;
        }
        System.out.println("total bill is : "+bill);

    }
}
