package com.Recursion.patterns;

import java.util.Arrays;

public class Selection_recursion {
    public static void main(String[] args) {

    int[] arr={4,3,2,1};
    selection(arr, arr.length,0,0);
        System.out.println(Arrays.toString(arr));

}
    static void selection(int[] arr, int e, int s,int max){
        if(e==0){
            return;
        }
        if(s<e){
            if(arr[s]>arr[max]){
                selection(arr,e,s+1,s);
            }else{
                selection(arr,e,s+1,max);
            }
        }else{
            int temp=arr[e-1];
            arr[e-1]=arr[max];
            arr[max]=temp;
            selection(arr,e-1,0,0);
        }
    }
}

