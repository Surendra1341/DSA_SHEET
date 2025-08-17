package com.Maths;
//https://leetcode.com/problems/integer-to-roman
class IntegerToRoman {
    public String intToRoman(int num) {
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i =0;
        String ans = "";
        while (num>0){
            if (num>=n[i]){
                ans=ans+s[i];
                num-=n[i];
            } else{
                i++;
            }
        }
        return ans;
    }
}