package com.Sorting.Question;

import java.util.Arrays;
/*
Given an integer array nums, move all the even integers at the beginning
 of the array followed by all the odd integers.
Return any array that satisfies this condition.
Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */

class SortByParity {
    public static void main(String[] args) {
        int[] arr={1,4,5,8,0};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }
    public static int[] sortArrayByParity(int[] nums) {

        int i=0;
        int j=1;
        while(i<nums.length && j< nums.length){
            if(nums[i]%2 != 0){
                if(nums[j]%2==0){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                    j++;
                }else{
                    j++;
                }
            }else{
                i++;
                j++;
            }
        }
        return nums;
    }


}