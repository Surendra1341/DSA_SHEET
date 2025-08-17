package com.Recursion.BackTracking;

import java.util.ArrayList;

public class Maze_Problem {
    public static void main(String[] args) {
        //m1 for just counting
        System.out.println(count(3, 3));
        //m2 for print all the ways
        path("", 3,3);

        //m3 return list of path
        System.out.println(pathRet("", 3,3));

        // m4 if add 1 more direction i.e diagonally(d)
        System.out.println(pathRetDia("",3,3));

        //m5 when there is restriction  now we start with (0,0)
        boolean[][] board={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        pathRestriction("",board,0,0);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }
    static void path(String p, int r,int c){
        if(r==1 && c==1){
            System.out.print(p+" ");
            return;
        }
       if(r>1) {
           path(p+'D',r-1,c);
       }
       if(c>1) {
           path(p+'R',r,c-1);
       }
    }
    static ArrayList<String> pathRet(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1) {
            ans.addAll(pathRet(p+'D',r-1,c));
        }
        if(c>1) {
            ans.addAll(pathRet(p+'R',r,c-1));
        }
        return ans;
    }
    static ArrayList<String> pathRetDia(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1 && c>1) {
            ans.addAll(pathRetDia(p+'d',r-1,c-1));
        }
        if(r>1) {
            ans.addAll(pathRetDia(p+'V',r-1,c));
        }
        if(c>1) {
            ans.addAll(pathRetDia(p+'H',r,c-1));
        }
        return ans;
    }

    static void pathRestriction(String p,boolean[][] maze ,int r,int c){
        if(r==maze.length-1 && c==maze[0].length -1){
            System.out.print(p+" ");
            return;
        }
        if(!maze[r][c]){    //check restriction
            return;
        }
        if(r< maze.length-1) {
            pathRestriction(p+'D',maze,r+1,c);  //here we increase because starts with 0,0
        }
        if(c<maze[0].length -1) {
            pathRestriction(p+'R',maze, r ,c+1); //similarly
        }
    }

}
