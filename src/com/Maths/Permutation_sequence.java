package com.Maths;

import java.util.ArrayList;
import java.util.Collections;

class Permutation_sequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
    public static String getPermutation(int n, int k) {
        StringBuilder up=new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            up.append(i);
        }
        ArrayList<String> ans=permutationsList("",up.toString());
        Collections.sort(ans);
         return ans.get(k-1);
    }
    static ArrayList<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            ans.addAll(permutationsList(first+ch+second,up.substring(1)));
        }
        return ans;
    }
}