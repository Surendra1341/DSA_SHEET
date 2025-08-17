package com.Hashmaps;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
/*
        String name="Surendra";
        Integer a=14243424;
        int code1=name.hashCode();
        int code2=a.hashCode();
        System.out.println(code1);
        System.out.println(code2);
*/
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Kunal",89);
        map.put("karan",99);
        map.put("rahul",94);

        System.out.println(map.get("karan"));
        System.out.println(map.getOrDefault("apoorv",78));
        System.out.println(map.containsKey("karan"));


        HashSet<Integer> set=new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(56);
        set.add(98);
        set.add(47);
        System.out.println(set);


        //self implemented no chaining or probing is done
        MapUsingHash personalMap=new MapUsingHash();
        personalMap.put("Mango","King of Fruits");
        personalMap.put("Apple","Sweet red fruit");
        System.out.println(personalMap.get("Mango"));


        //use HashMap Final self implemented

    }
}
