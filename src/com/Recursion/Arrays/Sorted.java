package com.Recursion.Arrays;
//checking sorted or not
public class Sorted {
    public static void main(String[] args) {
        int[] arr={1,2,3,5,9,0};
        System.out.println(sorting(arr, 0));
    }
    static boolean sorting(int[] arr,int i){
        if(i== arr.length-1){
            return true;
        }
        return arr[i]<arr[i+1] && sorting(arr,i+1);
    }
}
