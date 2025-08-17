package com.Recursion.StringAndSubset;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        seq("","abc"); //m1
        System.out.println(seq1("","abc"));  //m2
        //if you want to add the ascii value also

        seqAscii("","abc");

    }
    static void seq(String p,String up){   //p-process    up- unprocessed
        if(up.isEmpty()){
            System.out.print(p +" ");
            return;
        }
        char ch=up.charAt(0);
        seq(p+ch,up.substring(1));
        seq(p,up.substring(1));
    }
    static ArrayList<String> seq1(String p, String up){   //p-process    up- unprocessed
        if(up.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
       ArrayList<String> left= seq1(p+ch,up.substring(1));
        ArrayList<String> right=  seq1(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    static void seqAscii(String p,String up){   //p-process    up- unprocessed
        if(up.isEmpty()){
            System.out.print(p +" ");
            return;
        }
        char ch=up.charAt(0);
        seqAscii(p+ch,up.substring(1));
        seqAscii(p,up.substring(1));
        seqAscii(p+ ( ch + 0 ),up.substring(1));

    }
}

