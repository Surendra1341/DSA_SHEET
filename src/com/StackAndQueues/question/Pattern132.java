package com.StackAndQueues.question;

import java.util.Stack;

class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}