package com.Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr){
        int max= Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max/exp >0 ; exp*=10) {
            countSort(arr,(int)Math.pow(10,exp));
        }

    }

    private static void countSort(int[] arr, int exp) {
        int n= arr.length;
        int[] output=new int[n];
        int[] count=new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i]/exp)%10]++;
        }
        System.out.println("count arr for  " + exp + " : " +Arrays.toString(count));
        for (int i = 1; i < 10; i++) {    // adjust count[i] for getting the original arr index the count will add on when freq is increase
            count[i]=count[i]+count[i-1];
        }

        System.out.println(" upadated count arr for : "  +Arrays.toString(count));
        //we increase by one always before adjust we want one less index expected
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1] =arr[i];
            count[(arr[i]/exp)%10]--;
        }
        System.out.println(" output arr  : "  +Arrays.toString(count));

        System.arraycopy(output,0,arr,0, n);

    }

    public static void main(String[] args) {
        int[] arr={29,83,471,36,91,8};
        System.out.println("original arr : "+Arrays.toString(arr));
        radixSort(arr);
        System.out.println("sorted arr : "+Arrays.toString(arr));
    }

}
