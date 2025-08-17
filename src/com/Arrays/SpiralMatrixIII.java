package com.Arrays;
//https://leetcode.com/problems/spiral-matrix-iii
class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans=new int[rows*cols][2];
        int count=0;
        int i=rStart,j=cStart;
        int n=1;
        ans[count][0]=rStart;
        ans[count][1]=cStart;
        count++;
        while(count<rows*cols){
            //right moving
            for (int k = 0; k < n; k++) {
                j++;
                if(i>=0 && i< rows && j>=0 && j< cols ){
                    ans[count][0]=i;
                    ans[count][1]=j;
                    count++;
                }
            }
            //down moving
            for (int k = 0; k < n; k++) {
                i++;
                if(i>=0 && i< rows && j>=0 && j< cols ){
                    ans[count][0]=i;
                    ans[count][1]=j;
                    count++;
                }
            }
            n++;  // changing moving size
            for (int k = 0; k < n; k++) {
                j--;
                if(i>=0 && i< rows && j>=0 && j< cols ){
                    ans[count][0]=i;
                    ans[count][1]=j;
                    count++;
                }
            }
            for (int k = 0; k < n; k++) {
                i--;
                if(i>=0 && i< rows && j>=0 && j< cols ){
                    ans[count][0]=i;
                    ans[count][1]=j;
                    count++;
                }
            }
            n++;
        }
        return ans;
    }
}