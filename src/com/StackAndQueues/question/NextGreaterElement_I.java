package com.StackAndQueues.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        Arrays.fill(ans,-1);
        for(int i=0;i< nums1.length;i++){
            boolean checker=false;
            for (int j = 0; j < nums2.length; j++) {
                if(checker || nums1[i]==nums2[j]){
                    checker=true;
                    if(nums2[j]>nums1[i]){
                        ans[i]=nums2[j];
                        break;
                    }
                }
            }

        }
        return ans;
    }

    public int[] nextGreaterElement_m2(int[] n1, int[] n2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=n2.length-1;i>=0;i--){
            int num=n2[i];
            while(!s1.isEmpty() && s1.peek()<=num){
                s1.pop();
            }
            if(!s1.isEmpty()) map.put(num,s1.peek());

            s1.push(num);
        }

        for (int i = 0; i < n1.length; i++) {
            n1[i] = map.getOrDefault(n1[i], -1);
        }
        return n1;
    }
}