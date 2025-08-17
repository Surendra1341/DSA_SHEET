package com.Maths;

public class Power {
    public static void main(String[] args) {
        int a=3,b=6;
        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans*=a;
            }
            a=a*a;
            b=b>>1;
        }
        System.out.println(ans);
    }
}
