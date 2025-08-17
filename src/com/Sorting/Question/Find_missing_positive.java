package com.Sorting.Question;
/*Given an unsorted integer array arr.Return the smallest positive integer that is not present in arr.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */


//hard one

import java.util.Arrays;

public class Find_missing_positive {
    public static void main(String[] args) {
int[] arr={3,4,-1,1};
        System.out.println(firstMissingPositive(arr));
    }
    public  static int firstMissingPositive(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i]>0 && arr[i]<=arr.length && arr[i] != arr[correct]  ) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return j+1;
            }
        }
        return arr.length+1;
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
