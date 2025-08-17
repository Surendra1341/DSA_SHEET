package com.StackAndQueues.question;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                intStack.push(num);
                stringStack.push(str.toString());
                num = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                int count = intStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int i = 0; i < count; i++) {
                    temp.append(str);
                }
                str = temp;
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}