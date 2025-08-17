package com.Maths;
//https://leetcode.com/problems/multiply-strings
class MultiplyString {
    public String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0) return "0";
        char[] s1= reverse(num1);
        char[] s2=reverse(num2);
        int[] result=new int[s1.length+s2.length];
        for (int i = 0; i < s1.length; i++) {
            int carry=0;
            int start=i;
            for (int j = 0; j < s2.length; j++) {
                int n1=s1[i]-'0';
                int n2=s2[j]-'0';
                int sum= (n1*n2) +carry +  result[start];
                carry=sum/10;
                result[start++]=sum%10;
            }
            if(carry!=0) result[start]=carry;
        }
        int i=result.length-1;
        while(i>0 && result[i]==0) i--;
        StringBuilder ans=new StringBuilder("");
        while(i>=0){
            ans.append(result[i--]);
        }
        return ans.toString();

    }

    private char[] reverse(String num2) {
        char[] ans= num2.toCharArray();
        int start=0;
        int end=ans.length-1;
        while(start<end){
            char temp= ans[start];
            ans[start]=ans[end];
            ans[end]=temp;
            start++;
            end--;
        }
        return ans;
    }
}