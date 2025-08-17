package com.Recursion.leetcode;

import java.util.Stack;
//hard
class ParsingBooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> characterStack= new Stack<>();
        Stack<Character> operatorStack= new Stack<>();


        for(char c: expression.toCharArray()){
            if(c == ',') continue;
            if(c == '!' || c == '&' || c == '|'){
                operatorStack.push(c);
            }else if(c == ')'){
            //logic
                StringBuilder expressionBuilder = new StringBuilder();
                while (characterStack.peek() != '(') {
                    expressionBuilder.append(characterStack.pop());
                }
                characterStack.pop(); // remove '('
                char operator = operatorStack.pop();

                String subExpr = expressionBuilder.toString();
                boolean result;

                if (operator == '!') {
                    // Only one value should be in subExpr
                    result = subExpr.charAt(0) == '0'; // NOT false = true
                } else if (operator == '&') {
                    result = true;
                    for (int i = 0; i < subExpr.length(); i++) {
                        if (subExpr.charAt(i) == '0') {
                            result = false;
                            break;
                        }
                    }
                } else { // operator == '|'
                    result = false;
                    for (int i = 0; i < subExpr.length(); i++) {
                        if (subExpr.charAt(i) == '1') {
                            result = true;
                            break;
                        }
                    }
                }

// Push result back to characterStack as '1' or '0'
                characterStack.push(result ? '1' : '0');

            }else{
                if(c == 'f') characterStack.push('0');
                else if(c == 't') characterStack.push('1');
                else characterStack.push(c);
            }
        }
        return characterStack.pop()=='1';
    }
}