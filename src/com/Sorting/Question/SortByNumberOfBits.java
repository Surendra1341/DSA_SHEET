package com.Sorting.Question;

import java.util.ArrayList;
import java.util.Arrays;
//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits
class SortByNumberOfBits {
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]+=Integer.bitCount(arr[i])*10001;
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]%10001;
        }
        return arr;
    }
}