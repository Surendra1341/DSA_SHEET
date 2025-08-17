package com.Sorting.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/minimum-absolute-difference
class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-arr[i-1]<diff){
                diff=arr[i]-arr[i-1];
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i]-arr[i-1]==diff){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return ans;
    }
}