package com.Sorting.Question;

import java.util.ArrayList;
import java.util.List;
//Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in arr.
//Google question
class FindAllMissing {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(arr));
    }
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for (int j = 0; j <arr.length; j++) {
            if(arr[j]!=j+1){
                ans.add(j+1);
            }

        }
        return ans;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}