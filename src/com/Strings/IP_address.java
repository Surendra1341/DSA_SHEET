package com.Strings;

public class IP_address {
    public static void main(String[] args) {
        String a="255.100.50.0";
        System.out.println(defangIPaddr(a));
    }
    public static String defangIPaddr(String address) {
       return address.replace(".","[.]");
    }
}