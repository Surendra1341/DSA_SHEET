package com.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2Graph {

    class Pair{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" +  node + "," + weight +")";
        }
    }

    int[][] adjMatrix;

    List<List<Integer>> adjList;

    List<List<Pair>> adjListWithWeight;


     public L2Graph(int nodes){
        adjMatrix = new int[nodes][nodes];  // initially fill with 0
         adjList = new ArrayList<>();

         adjListWithWeight = new ArrayList<>();

         for(int i = 0; i < nodes; i++){
             adjList.add(new ArrayList<>());  // add empty list
             adjListWithWeight.add(new ArrayList<>());
         }


    }

    public void addEdgeInMatrix(int edges[][],boolean isDirected){

         for (int edge[] : edges) {
             int u = edge[0];
             int v = edge[1];
             // directed
             if(isDirected){
                 adjMatrix[u][v] = 1;
             }else {
                 // undirected
                 adjMatrix[u][v] = 1;
                 adjMatrix[v][u] = 1;
             }

         }
    }

    public void addEdgeWithWeightInMatrix(int edges[][],boolean isDirected){

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // directed
            if(isDirected){
                adjMatrix[u][v] = weight;
            }else {
                // undirected
                adjMatrix[u][v] = weight;
                adjMatrix[v][u] = weight;
            }

        }
    }

    public void printGraph(){
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    public void addEdgeInList(int edges[][],boolean isDirected){

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            // directed
            if(isDirected){
                adjList.get(u).add(v);
            }else {
                // undirected
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

        }
    }

    public void printList(){
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i +"-> "+adjList.get(i));
        }
    }

    public void printListWithWeight(){
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print(i +"-> ");
            System.out.print("[");
            for (int j = 0; j < adjListWithWeight.get(i).size(); j++) {
                System.out.print(adjListWithWeight.get(i).get(j)+",");
            }
            System.out.print("]");
            System.out.println();
        }
    }



    public void addEdgeWithWeightInList(int edges[][],boolean isDirected){

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // directed
            if(isDirected){
                adjListWithWeight.get(u).add(new Pair(v,weight));
            }else {
                // undirected
                adjListWithWeight.get(u).add((new Pair(v,weight)));
                adjListWithWeight.get(v).add((new Pair(u,weight)));
            }

        }
    }



    public void findDegreeInUndirected(int edges[][],int nodes){
         int[] degree = new int[nodes];
        for (int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            degree[from]++;
            degree[to]++;
        }
        for (int i = 0; i < degree.length; i++) {
            System.out.println("degree("+i+") -> "+degree[i]);
        }
    }

    public void findDegreeInDirected(int edges[][],int nodes){
        int[] inDegree = new int[nodes];
        int[] outDegree = new int[nodes];
        for (int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            outDegree[from]++;
            inDegree[to]++;
        }
        for (int i = 0; i <nodes; i++) {
            System.out.println("outDegree("+i+") -> "+outDegree[i]+"  ||   "+"inDegree("+i+") -> "+inDegree[i]);
        }
    }






    public static void main(String[] args) {

    /*

        int[][] edges = { {0,2},{0,1},{2,3}};
        int nodes = 4;

        // undirected
        L2Graph graph = new L2Graph(nodes);
        graph.addEdgeInMatrix(edges,false);
        System.out.println("undirected");
        graph.printGraph();


        //  directed
        L2Graph graph2 = new L2Graph(nodes);
        graph2.addEdgeInMatrix(edges,true);
        System.out.println("directed");
        graph2.printGraph();

 */



        /*
        int[][] edges = { {0,2,10},{0,1,20},{2,3,30}};
        int nodes = 4;
        //  // un directed weighted graph
        L2Graph graph = new L2Graph(nodes);
        graph.addEdgeWithWeightInMatrix(edges,false);
        System.out.println(" // un directed weighted graph");
        graph.printGraph();


        //  directed weighted
        L2Graph graph2 = new L2Graph(nodes);
        graph2.addEdgeWithWeightInMatrix(edges,true);
        System.out.println("directed weighted");
        graph2.printGraph();

         */

/*
        int[][] edges = { {0,2},{0,1},{2,3}};
        int nodes = 4;
//        undirected List
       L2Graph graph = new L2Graph(4);
       graph.addEdgeInList(edges,false);
        System.out.println(" // un directed  List");
       graph.printList();


        //  directed list
        L2Graph graph2 = new L2Graph(nodes);
        graph2.addEdgeInList(edges,true);
        System.out.println("directed list");
        graph2.printList();

 */


        /*
        int[][] edges = { {0,2,10},{0,1,20},{2,3,30}};
        int nodes = 4;
//        undirected List with wight
        L2Graph graph = new L2Graph(4);
        graph.addEdgeWithWeightInList(edges,false);
        System.out.println(" undirected List with wight");
        graph.printListWithWeight();


        //  directed list
        L2Graph graph2 = new L2Graph(nodes);
        graph2.addEdgeWithWeightInList(edges,true);
        System.out.println("directed List with wight");
        graph2.printListWithWeight();


         */

        // finding degree

        int[][] edges = { {0,2},{0,1},{1,3}};
        int nodes = 4;
        L2Graph graph = new L2Graph(nodes);
        System.out.println("degree in Undirected Graph");
        graph.findDegreeInUndirected(edges, nodes);
        System.out.println("degree in directed Graph");
        graph.findDegreeInDirected(edges, nodes);









    }



}
