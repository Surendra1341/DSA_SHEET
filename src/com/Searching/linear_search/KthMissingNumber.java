package com.Searching.linear_search;
//https://leetcode.com/problems/kth-missing-positive-number
class KthMissingNumber {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
    }
    public static int findKthPositive(int[] arr, int k) {
        int i=0;
        int ans=0;
        int ptr=0;
        while(i< arr.length){
            if(k==0){
                return ans;
            }
            if(arr[i]!=ptr+1){
                k--;
                ans=ptr+1;
                ptr++;
            }else{
                i++;
                ptr++;
            }
        }
        return arr[arr.length-1]+k;
    }
}