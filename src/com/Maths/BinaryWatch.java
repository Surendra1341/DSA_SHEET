package com.Maths;

import java.util.ArrayList;
import java.util.List;

class BinaryWatch {
    public List<String> readBinaryWatch(int n) {
        List<String> list =new ArrayList<>();
        if(n>=9) return list;
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                if(Integer.bitCount(hour)+Integer.bitCount(min) == n)
                    list.add(hour + (min < 10 ? ":0" : ":") + min);
            }
        }
        return list;
    }
}