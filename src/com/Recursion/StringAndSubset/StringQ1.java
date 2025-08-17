package com.Recursion.StringAndSubset;

public class StringQ1 {
    public static void main(String[] args) {
        //m1
        skip("","baccad");
        //m2
        System.out.println(skip("baccad"));
        //if you want to remove a string like apple
        System.out.println(skipApple("baappledap"));

    }
    static void skip(String n,String o){
        if(o.isEmpty()){
            System.out.println(n);
            return;
        }
        char ch=o.charAt(0);
        if(ch=='a'){
            skip(n,o.substring(1));
        }else{
            skip(n+ch,o.substring(1));
        }
    }
    static String skip(String o){
        if(o.isEmpty()){
            return "";
        }
        char ch=o.charAt(0);
        if(ch=='a'){
             return skip(o.substring(1));
        }else{
            return  ch + skip(o.substring(1));
        }
    }
    static String skipApple(String o){
        if(o.isEmpty()){
            return "";
        }
        if(o.startsWith("apple")){
            return skipApple(o.substring(5));
        }else{
            return  o.charAt(0) + skipApple(o.substring(1));
        }
    }
}
