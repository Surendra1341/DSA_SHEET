package com.Arrays;

import java.util.ArrayList;
import java.util.List;
/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */

class Unique_elementMatrix {
    public static void main(String[] args) {
//        matrix = [[3,7,8],[9,11,13],[15,16,17]]
        //[[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        int[][] mat={{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(luckyNumbers(mat));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int Index=0;
        for (int i = 0; i < matrix.length; i++) {
            min=Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                    Index=j;
                }
            }
           if( checkmax(matrix,i,Index)){
               list.add(matrix[i][Index]);
           }

        }
return list;
    }
    static boolean checkmax(int[][] arr,int row, int index){
        int max=arr[row][index];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][index]>max){
                return false;
            }
        }
        return true;
    }

}