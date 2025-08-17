package com.Recursion.leetcode;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                integerStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder prev = stringStack.pop();
                int repeatTimes = integerStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
