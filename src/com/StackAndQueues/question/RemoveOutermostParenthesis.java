package com.StackAndQueues.question;

import java.util.Stack;
//https://leetcode.com/problems/remove-outermost-parentheses
class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        int size=0;
        StringBuilder str=new StringBuilder("");
        for (char ch : s.toCharArray()){
           if(ch=='('){
               if(stack.size()>0){
                   str.append(ch);
               }
               stack.push(ch);
           }else{
               stack.pop();
               if (stack.size()>0){
                   str.append(ch);
               }
           }
        }
return str.toString();
    }
}