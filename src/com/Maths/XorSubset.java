package com.Maths;

import java.util.ArrayList;
import java.util.List;

class XorSubset {
    public int subsetXORSum(int[] arr) {
        List<List<Integer>> ans=subset(arr);
        int result=0;
        for (List<Integer> list : ans){
            int temp=0;
            for (int num : list) temp= temp^num;
            result+=temp;
        }
        return result;
    }
     List<List<Integer>> subset(int[] arr){
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
}