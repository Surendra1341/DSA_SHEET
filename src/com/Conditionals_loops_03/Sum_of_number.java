package com.Conditionals_loops_03;

import java.util.Scanner;

public class Sum_of_number {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sumofnegative=0;
        int sumofeven=0;
        int sumofodd=0;
        System.out.println("enter the numbers you want add and then enter o for sum ::");
        while (true)
        {
            int a= input.nextInt();
            if(a==0) {
                break;
            }
            if(a<0){
                sumofnegative+=a;
            }
            else {
                if(a%2==0){
                    sumofeven+=a;
                }else{
                    sumofodd+=a;
                }

            }

        }
        System.out.println("sum of negative number is :"+sumofnegative);
        System.out.println("sum of positive even number is : "+sumofeven);
        System.out.println("sum of positive odd number is : "+sumofodd);

    }
}
