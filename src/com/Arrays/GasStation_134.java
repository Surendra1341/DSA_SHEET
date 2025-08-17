package com.Arrays;

class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] += -cost[i];
            sum += gas[i];
        }
        if (sum < 0) return -1;
        int prev = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            prev += gas[i];
            if (prev < 0) {
            prev=0;
            start=i+1;
            }
        }
        return start;
    }
}