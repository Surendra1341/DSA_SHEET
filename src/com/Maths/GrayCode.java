package com.Maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/gray-code
class GrayCode {
   public List<Integer> grayCode(int n) {
       List<Integer> list =new ArrayList<>();
       list.add(0);
       list.add(1);

       for (int i = 2; i <=n; i++) {
           List<Integer> rev=new ArrayList<>(list);
           Collections.reverse(rev);
           int checker= list.size();
           for (int j = 0; j < checker; j++) {
               list.add(checker + rev.get(j));
           }
       }
       return list;
    }
}