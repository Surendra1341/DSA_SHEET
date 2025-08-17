package com.Maths;

public class Set_bits {
    public static void main(String[] args) {
        int n=200;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setbitd(n));
    }

    private static int setbitd(int n) {
        int count=0;
        while(n>0){
            count++;
            n=n-(n&(-n));
        }
        return count;
    }
}
