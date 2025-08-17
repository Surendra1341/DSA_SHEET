package com.SQRTDecomposition;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,3,5,2,7,6,3,1,4,8};
        int n=arr.length;

        //.built a block arr
        int sqrt= (int) Math.sqrt(n);

        int block_id= -1;
        int[] block=new int[sqrt+1];
        for (int i = 0; i < n; i++) {
            if( i % sqrt == 0){
                block_id++;
            }
            block[block_id]+=arr[i];
        }
        System.out.println(Arrays.toString(block));
        System.out.println(query(block , arr, 2,7, sqrt));
        update(block, arr,4,8,sqrt);
        System.out.println(Arrays.toString(block));
        System.out.println(query(block , arr, 2,7, sqrt));


    }

    public static int query(int[] block, int[] arr,int left, int right,int sqrt){
        int ans=0;
// left hand side
        while(left % sqrt !=0  && left< right && left!=0 ){
        ans+=arr[left++];
        }

        //middle  part
        while(left + sqrt <= right){
            ans += block[left/sqrt];
            left=left+ sqrt;
        }

        //right
        while(left<=right){
            ans+= arr[left++];
        }

        return ans;
    }
    public static  void update(int[] block , int[] arr, int i,int val , int sqrt){
        int block_id= i/ sqrt;
        block[block_id]+= ( val - arr[i]);
        arr[i] = val;
    }
}
