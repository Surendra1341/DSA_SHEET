package com.Sorting.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/matrix-cells-in-distance-order
class MatrixCellInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
      int[][] ans=new int[rows*cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j =0 ; j< cols ;j++){
                int box=i*cols +j;
                ans[box][0]=i;
                ans[box][1]=j;
            }
        }
        Arrays.sort(ans,(a,b)->{
            int d1= Math.abs(a[0]-rCenter)+Math.abs(a[1]-cCenter);
            int d2= Math.abs(b[0]-rCenter)+Math.abs(b[1]-cCenter);
            return d1-d2;  // which is smaller
        });
       return ans;
    }
}