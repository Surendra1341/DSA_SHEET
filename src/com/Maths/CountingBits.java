package com.Maths;
//https://leetcode.com/problems/counting-bits
class CountingBits {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i]=Integer.bitCount(i);
        }
        return arr;
    }
    //m2
    /*
     public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i]=arr[i>>1] + (i &1);
        }
        return arr;
    }
     */
}