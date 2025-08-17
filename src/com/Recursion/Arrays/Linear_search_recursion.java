package com.Recursion.Arrays;

import java.util.ArrayList;

public class Linear_search_recursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 9, 0, 9};

        // q1 just checking target is in array or not
        System.out.println(linear(arr, 9, 0));
        // q2 return index of target if find it otherwise -1
        System.out.println(linear_index(arr, 9, 0));

        /*
         M1
         creating arraylist outside
        */
            //                   all_target(arr,9,0);
          //                       System.out.println(list);

        /* M2
        passing arraylist as argument
         */
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(all_target1(arr,9,0, list ));

        // M3 creating AL in different call when it return a AL  from end it stored in that call  and  return list and
        // the list to above stored end list and also in that call repeat process

        System.out.println(all_target2(arr,9,0));


    }

    // return available or not
    static boolean linear(int[] arr, int target, int i) {
        if (i == arr.length) {
            return false;
        }
        return arr[i] == target || linear(arr, target, i + 1);
    }

    // return index
    static int linear_index(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return linear_index(arr, target, i + 1);
    }

    //for finding all target
    static ArrayList<Integer> list = new ArrayList<>();

    static void all_target(int[] arr, int target, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == target) {
            list.add(i);
        }
            all_target(arr, target, i + 1);

    }
    static ArrayList<Integer> all_target1(int[] arr, int target, int i,ArrayList<Integer> list) {
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
       return all_target1(arr, target, i + 1,list);

    }
    static ArrayList<Integer> all_target2(int[] arr, int target, int i) {
        ArrayList<Integer> list=new ArrayList<>();
        if (i == arr.length) {
            return list;
        }
        //it will contain answer for that fun call only
        if (arr[i] == target) {
            list.add(i);
        }
        ArrayList<Integer> ansFromBelowCall= all_target2(arr, target, i + 1);

        list.addAll(ansFromBelowCall);
        return list;
    }
}

