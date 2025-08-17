package com.Conditionals_loops_03;

import java.util.Scanner;

public class Vowel_Consonant {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("enter any alphabet from lower case : ");
        char ch= input.next().charAt(0);
        if( ch=='a'  || ch=='e'  ||  ch=='i' || ch=='o' || ch=='u'){
            System.out.println(ch+ " is vowel");
        }else {
            System.out.println(ch+ " is consonant");
        }


    }
}
