package com.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Bubble_sort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 6};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr) {
        boolean s;
        for (int i = 0; i < arr.length; i++) {
            s = false;
            //for each step max will come at last index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the items is less than previous items
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    s = true;
                }
            }
            if (!s) {
                break;
            }
        }
    }
}

