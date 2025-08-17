package com.Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 */
//https://leetcode.com/problems/permutation-sequence
class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,5));
    }
    public static String getPermutation(int n, int k) {
            List<Integer> fact=new ArrayList<>();
            int start=1;
            //store all factorial
            for (int i=1;i<=n;i++){
                fact.add(start);
                start*=i;
            }
          List<Integer> digits=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            digits.add(i+1);
        }
            char[] ans=new char[n];
            helper(n,k,ans,0,fact,digits);
        System.out.println(Arrays.toString(ans));
            return String.valueOf(ans);

    }

    private static void helper(int n, int k, char[] ans, int i, List<Integer> fact , List<Integer> digits) {
        if(n==1){
            ans[i]= (char)(digits.get(0)+'0');
            return;
            }

        int index= k/fact.get(n-1);    //size
        if(k%(fact.get(n-1))==0) index--;
        ans[i]= (char)(digits.get(index)+'0');
        digits.remove(index);
        k=k-(fact.get(n-1)*index);
        helper(n-1,k,ans,i+1,fact,digits);
    }
}