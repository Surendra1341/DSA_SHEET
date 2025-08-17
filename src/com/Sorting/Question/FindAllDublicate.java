package com.Sorting.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDublicate {
    public static void main(String[] args) {
        int[] arr={1,3,2,2,4,5,4};
        System.out.println(findDuplicates(arr));
    }
    public static List<Integer> findDuplicates(int[] arr) {
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
                ans.add(arr[j]);
            }

        }
        return ans;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    public  List<Integer> findAllDuplicates(int[] arr){
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(hashSet.contains(arr[i])){
                ans.add(arr[i]);
            }
            hashSet.add(arr[i]);
        }
        return ans;

    }
}