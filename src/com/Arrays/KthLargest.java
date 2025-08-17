package com.Arrays;

import java.util.PriorityQueue;

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if(minHeap.size()>k) minHeap.remove();
        }

        return minHeap.poll();
    }
}