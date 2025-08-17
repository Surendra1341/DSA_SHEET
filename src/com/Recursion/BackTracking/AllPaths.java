package com.Recursion.BackTracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] path=new int[board.length][board[0].length];

        allPath("",board,0,0);
        System.out.println();
       allPathPrint("",board,0,0,path,1);
    }
    static void allPath(String p, boolean[][] maze , int r, int c){
        if(r==maze.length-1 && c==maze[0].length -1){
            System.out.print(p+" ");
            return;
        }
        if(!maze[r][c]){    //check restriction
            return;
        }
        maze[r][c]=false; // considering the block in my path

        if(r< maze.length-1) {
            allPath(p+'D',maze,r+1,c);//here we increase because starts with 0,0
        }
        if(c<maze[0].length -1) {
            allPath(p+'R',maze, r ,c+1); //similarly
        }
        if(r>0) {
            allPath(p+'U',maze,r-1,c);  //here we increase because starts with 0,0
        }
        if(c>0) {
            allPath(p+'L',maze,r,c-1);  //here we increase because starts with 0,0
        }
        //this is the line where all call is done
        //so before function get removed, also remove the change that is done by function
        maze[r][c]=true;

    }


    static void allPathPrint(String p, boolean[][] maze , int r, int c,int[][] path,int step){
        if(r==maze.length-1 && c==maze[0].length -1){
            path[r][c]=step;         //when we at last position ie also a step
            for(int[] arr : path){
               System.out.println(Arrays.toString(arr));
           }
            System.out.println(p+" ");
            System.out.println("\n");

            return;
        }
        if(!maze[r][c]){    //check restriction
            return;
        }
        maze[r][c]=false; // considering the block in my path
        path[r][c]=step;   //initially start with 1

        if(r< maze.length-1) {
            allPathPrint(p+'D',maze,r+1, c , path ,step+1);//here we increase because starts with 0,0
        }
        if(c<maze[0].length -1) {
            allPathPrint(p+'R',maze, r ,c+1,path,step+1); //similarly
        }
        if(r>0) {
            allPathPrint(p+'U',maze,r-1,c,path,step+1);  //here we increase because starts with 0,0
        }
        if(c>0) {
            allPathPrint(p+'L',maze,r,c-1,path,step+1);  //here we increase because starts with 0,0
        }
        //this is the line where all call is done
        //so before function get removed, also remove the change that is done by function
        maze[r][c]=true;
        path[r][c]=0;

    }
}
