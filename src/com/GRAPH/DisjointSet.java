package com.GRAPH;

import java.util.Arrays;

public class DisjointSet {

    int[] parent;
    int[] rank;
    int components;

    public DisjointSet(int nodes) {  // 0 based -> (5) ->(0-4)
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.components = nodes;
        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    public int findRootParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findRootParent(parent[node]); // compression
    }

    public void unionByRank(int node1, int node2) {
        int root1 = findRootParent(node1);
        int root2 = findRootParent(node2);
        if (parent[root1]  == parent[root2]) return;
        this.components--;
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        }else if (rank[root2] < rank[root1]) {
            parent[root2] = root1;
        }else{
            parent[root2] = root1;
            rank[root1]++;
        }
    }


    // in this size is initialized with 1
    /*
     public void unionBySize(int node1, int node2) {
        int root1 = findRootParent(node1);
        int root2 = findRootParent(node2);
        if (parent[root1]  == parent[root2]) return;
        this.components--;
        if (size[root1] < size[root2]) {
            parent[root1] = root2;
            size[root2]+=size[root1];
        }else if (size[root2] < size[root1]) {
            parent[root2] = root1;
            size[root1]+=size[root2];
        }else{
            parent[root2] = root1;
            size[root1]+=size[root2];
        }
    }
     */

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(4);
        System.out.println("TOTAL COMPONENTS: " + ds.components);
        System.out.println(ds.findRootParent(0) == ds.findRootParent(3)? "same component":"different component");
        ds.unionByRank(0,3);
        System.out.println(Arrays.toString(ds.parent));
        System.out.println(Arrays.toString(ds.rank));
        System.out.println("TOTAL COMPONENTS: " + ds.components);
        System.out.println(ds.findRootParent(0) == ds.findRootParent(3)? "same component":"different component");

    }




}
