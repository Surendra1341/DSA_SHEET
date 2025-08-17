package com.Recursion.StringAndSubset;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        //not return just print
        permutations("", "abc");
        //return arraylist
        System.out.println(permutationsList("","abc"));
        //return number of combinations
        System.out.println(permutationsCount("","abc"));
    }
    static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        char ch=up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            permutations(first+ch+second,up.substring(1));
        }
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
    static int permutationsCount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        for (int i = 0; i <= p.length(); i++) {
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
           count+= permutationsCount(first+ch+second,up.substring(1));
        }
        return count;
    }
}
