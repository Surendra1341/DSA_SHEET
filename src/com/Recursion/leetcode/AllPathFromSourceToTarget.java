package com.Recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

class AllPathFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        helper(0,graph.length-1,current,ans,graph);
        return ans;
    }

    private void helper(int source, int destination, List<Integer> current, List<List<Integer>> ans,int[][] graph) {
        if(source == destination) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int num : graph[source]) {
            current.add(num);
            helper(num, destination, current, ans, graph);
            current.remove(current.size()-1);
        }
    }
}