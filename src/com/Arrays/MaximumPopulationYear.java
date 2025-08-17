package com.Arrays;
//https://leetcode.com/problems/maximum-population-year
class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] check=new int[2051];
        //basically increase and decrease population at particular year
        for (int[] log : logs) {
            check[log[0]]++;
            check[log[1]]--;
        }
        int maxPopulation=check[1950];
        int year=1950;
        for (int i = 1951; i < check.length; i++) {
            check[i]+=check[i-1];  // here the total population at that year
            if (check[i] > maxPopulation) {
                maxPopulation = check[i];
                year =i;
            }
        }
        return year;
    }
}