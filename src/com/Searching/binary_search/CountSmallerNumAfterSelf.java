package com.Searching.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CountSmallerNumAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for(int i=nums.length-1;i>=0;i--){

            int pos = findPosition(sorted,nums[i]);

            sorted.add(pos,nums[i]);
            ans.add(pos);
        }
        Collections.reverse(ans);  // The result needs to be reversed
        return ans;


    }

    private int findPosition(List<Integer> list, int target) {
        int l = 0;
        int r = list.size()-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}