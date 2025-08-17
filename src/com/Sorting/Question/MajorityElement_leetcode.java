package com.Sorting.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
 You may assume that the majority element always exists in the array.


Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

class MajorityElement_leetcode {

    /*//m1
        public static int majorityElement(int[] nums) {
             Arrays.sort(nums);                 // if array is sort then the element appear more than n/2
                                                // will always be middle one also
             return nums[nums.length/2];
        }
    */
    public int majorityElement(int[] nums) {
        //m2
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry :  map.entrySet()){
            if(entry.getValue()> nums.length/2) return entry.getKey();
        }
        return 0;
    }
}