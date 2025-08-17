package com.StackAndQueues.question;

import java.util.Stack;

class CompetitiveSequence {
    public int[] mostCompetitive(int[] nums, int k) {
        int removed = nums.length - k;
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {

            while (!stack.isEmpty() && num < stack.peek() && removed >0) {
                stack.pop();
                removed--;
            }
            stack.push(num);
        }
        while(stack.size()>k) stack.pop();
        int index =k - 1;
        while(index>=0){
            result[index--] = stack.pop();
        }
        return result;
    }
}