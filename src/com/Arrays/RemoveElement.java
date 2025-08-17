package com.Arrays;
//https://leetcode.com/problems/remove-element?envType=study-plan-v2&envId=top-interview-150
class RemoveElement {
    public int removeElement(int[] arr, int val) {
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]==val){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                right--;
            }else{
                left++;
            }
        }
        int count=0;
        for (int n : arr){
            if(n!=val) count++;
        }
        return count;
    }
}