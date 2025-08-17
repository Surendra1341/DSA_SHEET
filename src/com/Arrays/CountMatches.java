package com.Arrays;

import java.util.List;
/*
You are given an array items, where each items[i] = [typei, colori, namei] describes the type,
color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.
 */
class CountMatches {
    public static void main(String[] args) {
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
int check=0;
int count=0;
        if (ruleKey=="type"){
            check=0;
        }else if(ruleKey=="color"){
            check=1;
        }else{
            check=2;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(check).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}