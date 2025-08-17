package com.Sorting.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/sort-array-by-increasing-frequency
class SortByFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Integer[] arr=new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
            arr[i]=nums[i];
        }
        Arrays.sort(arr,(a,b)-> {
            int freq1=map.get(a);
            int freq2=map.get(b);
            if(freq1==freq2) return b - a;
            return freq1-freq2;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i]=arr[i];
        }
        return nums;

    }
}