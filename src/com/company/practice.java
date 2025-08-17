package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class practice {
    public static void main(String[] args) {
        int[] arr={2,3,2,2,3,7,3,7,8,8,7,8,5};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            ans+=arr[i];
        }
        return ans%3;
    }
}
