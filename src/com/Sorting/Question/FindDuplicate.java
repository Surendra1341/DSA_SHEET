package com.Sorting.Question;

class FindDuplicate {
    /*Given an array of integers arr containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in arr, return this repeated number.

You must solve the problem without modifying the array arr and using only constant extra space.


    */

    public static void main(String[] args) {
        int[] arr={3,1,3,4,2};
        System.out.println(findDuplicate(arr));
    }
    public static int findDuplicate(int[] arr) {
        int i = 0;

        while (i < arr.length) {

            if(arr[i]!=i+1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            }
                else {
                    i++;
                }

        }
        return -1;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}