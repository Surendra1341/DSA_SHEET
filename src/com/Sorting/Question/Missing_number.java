package com.Sorting.Question;

import java.net.BindException;

public class Missing_number {
    public static void main(String[] args) {
        /*
        Given an array nums containing n distinct numbers in the range [0, n],
        return the only number in the range that is missing from the array.
        */
        //Amazon question
        int[] arr={9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));

    }
    public static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct=arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j){
                return j;
            }
        }
return arr.length;
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
