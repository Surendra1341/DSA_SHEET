package com.Sorting.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/group-anagrams
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        boolean[] check=new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(check[i]) continue;
            List<String> list=new ArrayList<>();
            list.add(strs[i]);
            check[i]=true;
            for (int j = i+1; j < strs.length; j++) {
                if(!check[j]  && isAnagram(strs[i],strs[j])){
                    list.add(strs[j]);
                    check[j]=true;
                }
            }
            ans.add(list);
        }


        return ans;
    }

    private boolean isAnagram(String first, String second) {
        if(first.length()!=second.length()) return false;
        char[] arr1=first.toCharArray();
        char[] arr2=second.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}