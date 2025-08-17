package com.Recursion.StringAndSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> ans=subset(arr);

        //in this comment we print one by one list (subset)
/*
        for(  List<Integer> list: ans){
            System.out.println(list);
        }
*/
        System.out.println(ans);

        // when element are duplicate
        int[] arr1={2,1,2};
        System.out.println(subsetDuplicate(arr1));
    }

    //Q1
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());  //empty list is added first
        for(int nums : arr){      //
            int n= outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internel=new ArrayList<>(outer.get(i));  // copy bna rhe hai same size ka
                internel.add(nums);
                outer.add(internel);

            }
        }
return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());  //empty list is added first
        int start=0;
        int end=0;
        for (int i = 0; i < arr.length; i++) {
            start=0;
            // if current and previous element is same s=e+1;
            if(i>0 && arr[i]==arr[i-1]){
                 start=end+1;
            }
            end= outer.size()-1;

                int n= outer.size();
                for (int j = start; j < n; j++) {
                    List<Integer> internel = new ArrayList<>(outer.get(j));  // copy bna rhe hai same size ka
                    internel.add(arr[i]);
                    outer.add(internel);
                }

        }
        return outer;
    }
}
