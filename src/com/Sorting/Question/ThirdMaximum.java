package com.Sorting.Question;

import java.util.*;

/*
Given an integer array nums, return the third distinct maximum number
 in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
 */
class ThirdMaximum {
    public static void main(String[] args) {
        int[] nums={4,3,3,2,2,1};
        System.out.println(thirdMax(nums));
    }
    // m1
    public static int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=1;
        for (int i = n-1; i >0 ; i--) {
            if(nums[i]!=nums[i-1]){
                count++;
            }
            if(count==3){
                return nums[i-1];
            }
        }
        return nums[n-1];  //here if there is only 2 element then return 2 largest
    }

    //m2

    public static int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i=nums.length-1; i>=0; i--){
            set.add(nums[i]);
        }
        if(set.size() < 3) return Collections.max(set);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: set){
            pq.offer(num);
            if(pq.size() > 3) pq.poll();
        }

        if(pq.size() == 2) pq.poll();

        return pq.peek();

    }




}