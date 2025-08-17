package com.Searching.binary_search;
import java.util.Arrays;
//https://leetcode.com/problems/fair-candy-swap
class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1=0;
        int sum2=0;
        for (int num : aliceSizes) sum1+=num;
        for (int num : bobSizes)  sum2+=num;

        //basically the formula is AliceTotal -A[i]+B[j]==bobTotal -B[j] +A[i];
        //by solve this formula you get target and apply binary search
        Arrays.sort(bobSizes);

        for (int i = 0; i < aliceSizes.length; i++) {
            int target=(sum2 - sum1 + 2*aliceSizes[i])/2;
            if(binarySearch(bobSizes,target)){
                return new int[]{aliceSizes[i],target};
            }
        }
        return new int[0];
    }

    private boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return true;
            }
        }
        return false;
    }
}