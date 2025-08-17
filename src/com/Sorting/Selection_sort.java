package com.Sorting;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the max. and swap with correct index
            int last = arr.length - 1 - i;  // last wala index bataye gaa or dheere dheere cm hoga
            int maxindex = getMaxIndex(arr, 0, last);
            swap(arr, maxindex, last);

        }
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
