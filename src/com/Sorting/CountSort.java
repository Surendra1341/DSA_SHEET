package com.Sorting;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int[] countArr = new int[max + 1];

        for (int num : arr) {
            countArr[num]++;
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArr[i] > 0) {
                arr[index] = i;
                index++;
                countArr[i]--;
            }
        }
    }

    public static void countSortHash(int[] arr){
        if (arr == null || arr.length <= 1) return;
        int max=Arrays.stream(arr).max().getAsInt();   // shortcut to find max in arr
        int min=Arrays.stream(arr).min().getAsInt();
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int num : arr){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        int index=0;
        for (int i=min; i<=max ; i++) {
            int count= countMap.getOrDefault(i,0);
            for (int j = count; j >0 ; j--) {
                arr[index]=i;
                index++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 8, 2, 4, 4, 3, 8, 1, 9, 5};
//        countSort(arr);    //01
        countSortHash(arr);   // 02
        System.out.println(Arrays.toString(arr));

    }
}
