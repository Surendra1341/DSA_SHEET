package com.Sorting.Question;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//https://leetcode.com/problems/rank-transform-of-an-array
class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] sorted= Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i],i+1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}