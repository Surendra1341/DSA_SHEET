package com.Maths;

public class GCD_Lcm {
    public static void main(String[] args) {
        System.out.println(gcd(5,3));
        System.out.println(lcm(5,3));
    }

    private static int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }

    static int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}
