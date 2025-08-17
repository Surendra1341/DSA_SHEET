package com.Maths;

public class NewtonSQRT {
    public static void main(String[] args) {
        System.out.printf("%.2f",sqrt(40));
    }
    static double sqrt(double n){
        double x=n;
        double root=0.0;
        while(true){
             root=0.5*(x+(n/x));
            if(Math.abs(root-x)<1){  //you can adjust precision
                break;
            }
            x=root;
        }
return root;
    }
}
