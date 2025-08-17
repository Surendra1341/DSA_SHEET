package com.Arrays;

import com.Hashmaps.HashmapFinal;

import java.util.*;
//https://leetcode.com/problems/insert-delete-getrandom-o1?envType=study-plan-v2&envId=top-interview-150
class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;

    public RandomizedSet() {
       this.map=new HashMap<>();
       this.list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    
    public boolean remove(int val) {
       if(!map.containsKey(val)) return false;
        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}