package com.Maths;

import java.util.HashSet;
import java.util.Set;

class ConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> check=new HashSet<>();
        for(char ch : allowed.toCharArray()) check.add(ch);
        int count=0;
        for (String str : words) {
            boolean ans=true;
            for (char ch : str.toCharArray()){
                if(!check.contains(ch)){
                    ans=false;
                    break;
                }
            }
            if(ans) count++;
        }
        return count;
    }
}