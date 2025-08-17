package com.Maths;

public class Single_element_bit {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,8,8};
        System.out.println(unique(arr));
    }

    private static int unique(int[] arr) {
        int ans=0;
        for (int j : arr) {
            ans ^= j;
        }
        return ans;
    }
}

