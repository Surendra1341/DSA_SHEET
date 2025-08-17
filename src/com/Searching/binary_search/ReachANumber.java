package com.Searching.binary_search;

//https://leetcode.com/problems/reach-a-number
class ReachANumber {
    public static void main(String[] args) {
        System.out.println(reachNumber(-1));
    }

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, k = 0;
        while (sum < target) {
            k++;
            sum += k;
        }
        return (sum - target) % 2 == 0 ? k : k % 2 == 0 ? k + 1 : k + 2;
    }


}