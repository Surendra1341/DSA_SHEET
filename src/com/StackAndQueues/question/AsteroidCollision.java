package com.StackAndQueues.question;

import java.util.Stack;

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (num > 0) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)) stack.pop();
                if (!stack.isEmpty() && stack.peek() == Math.abs(num)) stack.pop();
                else if (stack.isEmpty() || stack.peek() < 0) stack.push(num);
            }
        }
        int[] result = new int[stack.size()];
        int i = result.length - 1;
        while (!stack.isEmpty()) result[i--] = stack.pop();
        return result;
    }
}