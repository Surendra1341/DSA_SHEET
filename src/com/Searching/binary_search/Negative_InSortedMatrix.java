package com.Searching.binary_search;
/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
 */
class Negative_InSortedMatrix {
    public static void main(String[] args) {
        int[][] arr={
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(arr));
    }
    public static int countNegatives(int[][] arr) {
        int c=arr[0].length-1;
        int r=0;
        int count=0;
        while(r<arr.length && c>=0){
            if(arr[r][c]<0){
                c--;
                count+= arr.length-r;
            } else{
                r++;
            }
        }
        return count;
    }
}