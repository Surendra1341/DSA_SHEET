package com.Maths;

public class Square_root {
    public static void main(String[] args) {
        int n=36;
        int p=3;
        System.out.printf("%.3f", root( n,p));
    }

    private static double root(int n,int p) {
        int s=0;
        int e=n;
        double root=0.0;
        if(s<=e){
            int m=s +(e-s)/2;
            if(m*m==n){
                return  m;
            }
            if (m * m < n) {
                s=m+1;
            }else{
                e=m-1;
            }
        }
        double j=0.1;
        for (int i = 0; i < p; i++) {
            while (root*root<=n){
                root+=j;
            }
            root-=j;
            j/=10;
        }
        return root;
    }
}
