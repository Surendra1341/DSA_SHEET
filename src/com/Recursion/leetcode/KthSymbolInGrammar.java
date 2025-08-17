package com.Recursion.leetcode;
/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence
of 0 with 01, and each occurrence of 1 with 10.
For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
 */

class KthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(5,16));
    }
    public static int kthGrammar(int n, int k) {
        if(n==0) return 0;
        int length = (1 << n) ;  // This is 2^n  basically checking that in which part in k
        /*
        n==1 > 0
        n==2 > 01
        n==3 > 0110
        n==4 > 01101001
        n=5  > 0110100110010110
        length is increasing 2^n exponentially
         */
        if(k<=length/2)  // if k is in first part then it is similar to above by observing
            return kthGrammar(n-1,k);


        //now below this if k in second half
        if(k%2!=0) {
            int i = kthGrammar(n - 1, k / 2 + 1);
            if (i == 1) return 1;
            return 0;  // ifi==0
        }

        //if k is even
            int i = kthGrammar(n - 1, k / 2 );
            if (i == 1) return 0;
            return 1;  // ifi==0


    }
}