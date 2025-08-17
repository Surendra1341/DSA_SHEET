package com.StackAndQueues.question;

import java.util.Stack;

class DuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder str=new StringBuilder("");
        for(char ch : s.toCharArray()){
            if(stack.size()>0 && ch==stack.peek()) {
                while (ch == stack.peek()) stack.pop();
                continue;
            }
            stack.push(ch);
        }
       while (!stack.isEmpty()){
           str.append(stack.pop());
       }
        return str.reverse().toString();
    }
}