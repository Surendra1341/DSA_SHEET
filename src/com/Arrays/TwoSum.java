package com.Arrays;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.isEmpty() && map.containsKey(target-arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}