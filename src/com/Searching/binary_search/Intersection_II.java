package com.Searching.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
 Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:
 */
class Intersection_II {
    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> set=new ArrayList<>();
        List<Integer> out=new ArrayList<>();

        for (int j : nums1) {
            set.add(j);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                out.add(nums2[i]);
                set.remove(Integer.valueOf(nums2[i]));
            }
        }
        int[] ans=new int[out.size()];
        for (int i = 0; i < out.size(); i++) {
            ans[i]= out.get(i);
        }
        return ans;
    }
}