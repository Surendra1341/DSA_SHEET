package com.GRAPH;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class GraphQuestion {

    //https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        // DFS Code
//            fillDfs(image, sr, sc, color, image[sr][sc]);
//            return image;

        // BFS
        int rows = image.length, cols = image[0].length;
        int curr = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int[][] adjList = {{row - 1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1}};
            for (int[] adj : adjList) {
                int r = adj[0], c = adj[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || curr != image[r][c]) continue;
                image[r][c] = color;
                queue.add(new int[]{r, c});
            }
        }

        return image;
    }


    public void fillDfs(int[][] image, int row, int col, int color, int cur) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || cur != image[row][col]) return;
        image[row][col] = color;
        fillDfs(image, row - 1, col, color, cur);
        fillDfs(image, row + 1, col, color, cur);
        fillDfs(image, row, col - 1, color, cur);
        fillDfs(image, row, col + 1, color, cur);
    }

//https://leetcode.com/problems/number-of-islands/description/
    public int numIslands(char[][] grid) {
        // DFS Code
          int islands = 0;
          for (int i = 0; i < grid.length; i++) {
              for (int j = 0; j < grid[0].length; j++) {
                  if (grid[i][j] == '1') {
                      islands++;
                      fillIslands(grid,i,j);
                  }
              }
          }
          return islands;
    }

    public void fillIslands(char[][] gird, int row, int col) {

        if (row < 0 || row >= gird.length || col < 0 || col >= gird[0].length || '1' != gird[row][col]) return;
        gird[row][col] = '2'; // visited
        fillIslands(gird, row - 1, col);
        fillIslands(gird, row + 1, col);
        fillIslands(gird, row, col - 1);
        fillIslands(gird, row, col + 1);
    }




    //https://leetcode.com/problems/word-ladder/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);  //fast checking
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if (wordSet.contains(beginWord))  wordSet.remove(beginWord); // check it remove exceptions
        int level = 0;
        while (!queue.isEmpty()) {
            int currLevelSize = queue.size();
            for (int i = 0; i < currLevelSize; i++) {
                String currWord = queue.poll();
                if(currWord.equals(endWord)) return level+1;
                List<String> neighbours = getNeighbours(currWord,wordSet); //adj list milegi
                for (String neighbour : neighbours) {
                    if(wordSet.contains(neighbour)){
                        wordSet.remove(neighbour); // visited
                        queue.offer(neighbour);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> getNeighbours(String node, HashSet<String> set) {
        List<String> neighbours = new LinkedList<>();
        for (int j = 0; j < node.length(); j++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == node.charAt(j)) continue; // Skip same character
                String newWord = node.substring(0, j) + ch + node.substring(j + 1);
                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }


//tle ->https://leetcode.com/problems/word-ladder-ii/description/
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       HashSet<String> wordSet = new HashSet<>(wordList);  //fast checking
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;
        List<String> dummy = new ArrayList<>();
        dummy.add(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(dummy);
        if (wordSet.contains(beginWord))  wordSet.remove(beginWord); // check it remove exceptions
        int level = 0;
        int resultLevel =-1;
        while (!queue.isEmpty()) {
            HashSet<String> usedWordSet = new HashSet<>();
            int currLevelSize = queue.size();
            for (int i = 0; i < currLevelSize; i++) {
                List<String> currWordList = queue.poll();
                String node = currWordList.get(currWordList.size() - 1);
                if(node.equals(endWord)) {
                   resultLevel=level;
                   res.add(currWordList);
                }
                List<String> neighbours = getNeighbours(node,wordSet); //adj list milegi
                for (String neighbour : neighbours) {
                    if(wordSet.contains(neighbour)){
                        currWordList.add(neighbour);
                        queue.offer(new ArrayList<>(currWordList));
                        currWordList.remove(neighbour);
                        usedWordSet.add(neighbour);
                    }
                }
            }
            for (String visited : usedWordSet){
                wordSet.remove(visited);
            }
            if (level == resultLevel) {
                break;
            }
            level++;
        }
        return res;
    }



    //https://leetcode.com/problems/evaluate-division/description/
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // gen adj map
        HashMap<String,HashMap<String ,Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String, Double>());
            }
            if(!map.containsKey(divisor)){
                map.put(divisor, new HashMap<String, Double>());
            }
            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1/value);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                result[i] = -1.0;
                continue;
            }else if (dividend.equals(divisor)) {
                result[i] = 1.0;
                continue;
            }else {
                HashSet<String> visited = new HashSet<>();
                result[i] = dfsCalculationEquation(dividend,divisor,1.0,visited,map);
            }

        }
        return result;
    }

    private double dfsCalculationEquation(String src, String target, double prod, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map) {
          double ret = -1;
          visited.add(src);
          if(map.get(src).containsKey(target)){
              ret = prod * map.get(src).get(target);
          }else {
              for (String neighbour : map.get(src).keySet()) {
                  if(!visited.contains(neighbour)){
                    ret =  dfsCalculationEquation(neighbour,target,prod*map.get(src).get(neighbour),visited,map);
                      if(ret != -1){
                          break;
                      }
                  }
              }
          }
          visited.remove(src);
          return ret;
    }

//https://leetcode.com/problems/get-watched-videos-by-your-friends/description/
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int currLevel=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curId = queue.poll();
                for (int friend : friends[curId]) {
                    if (!visited.contains(friend)) {
                        queue.offer(friend);
                        visited.add(friend);
                    }
                }
            }
            currLevel++;
            if (level == currLevel) {
                break;
            }
        }
        HashMap<String,Integer> freqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            for (String video : watchedVideos.get(curId)) {
                freqMap.put(video,freqMap.getOrDefault(video,0)+1);
            }
        }

        // custom sorting
        List<Pair> videoList = new ArrayList<>();
        for (String video : freqMap.keySet()) {
            videoList.add(new Pair(video,freqMap.get(video)));
        }

        Collections.sort(videoList);
        List<String> res = new ArrayList<>();
        for (Pair pair : videoList) {
            res.add(pair.video);
        }
        return res;

    }

    class Pair implements Comparable<Pair> {
        String video;
        int freq;
        public Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.freq == that.freq){
                return this.video.compareTo(that.video);
            }
          return   this.freq - that.freq;
        }
    }



    //https://leetcode.com/problems/rotting-oranges/description/
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) freshOranges++;
                 else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                }
            }
        if (freshOranges == 0) return 0;
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();  // np. of rotten oranges
            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                int x = location[0];
                int y = location[1];
                int[][] neighbours ={{x-1,y},{x+1,y},{x,y-1},{x,y+1}};
                for (int[] neighbour : neighbours) {
                    int r = neighbour[0];
                    int c = neighbour[1];
                    // out bound / rotten - visited
                    if ( r<0 || r>=n || c<0 || c>=m || grid[r][c] == 2  || grid[r][c] == 0) continue;
                    queue.offer(new int[]{r,c});
                    grid[r][c] = 2;
                }
            }
            time++;
            freshOranges-= queue.size();
            if (freshOranges == 0) {
                break;
            }
        }
        return freshOranges==0? time:-1;

    }


    //https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

       List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());  // add empty list
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        return dfsMinTime(0, -1, adjList, hasApple);
    }

    private int dfsMinTime(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        for (int neighbour : adj.get(node)) {
            if (neighbour == parent) continue;  // adj List contain parent also skip it
            int childTime = dfsMinTime(neighbour, node, adj, hasApple);
            if (childTime > 0 || hasApple.get(neighbour)) {
                time += childTime + 2; // go + return
            }
        }
        return time;
    }

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjList = new ArrayList<>(); for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());  // add empty list
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int component =0 ;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                component++;
                applyDfs(i,adjList,visited);
            }
        }
        return (n - component);
    }

    private void applyDfs(int src, List<List<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        for (int neighbour : adjList.get(src)) {
            if (!visited[neighbour]) {
                applyDfs(neighbour, adjList, visited);
            }
        }
    }



//https://leetcode.com/problems/accounts-merge/
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // adj map
        HashMap<String, List<String>> adjMap = new HashMap<>();
        for (List<String> account : accounts) {
            String firstMail = account.get(1);
            //add only if have more than 2 mail in list
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                if(!adjMap.containsKey(firstMail)) {
                    adjMap.put(firstMail, new ArrayList<>());
                }
                adjMap.get(firstMail).add(email);

                if(!adjMap.containsKey(email)) {
                    adjMap.put(email, new ArrayList<>());
                }
                adjMap.get(email).add(firstMail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();

        for (List<String> account : accounts) {
            String firstMail = account.get(1);
            if (!visited.contains(firstMail)) {
                List<String> subList = new ArrayList<>();
                dfsAccountMerge(firstMail,visited,adjMap,subList);
                Collections.sort(subList);
                subList.add(0,account.get(0));
                result.add(subList);
            }
        }


return result;

    }

    private void dfsAccountMerge(String srcEmail, HashSet<String> visited, HashMap<String, List<String>> adjMap, List<String> subList) {
        visited.add(srcEmail);
        subList.add(srcEmail);
        if (!adjMap.containsKey(srcEmail)) {
            return;
        }

        for (String neighbour : adjMap.get(srcEmail)) {
            if (!visited.contains(neighbour)) {
                dfsAccountMerge(neighbour, visited, adjMap, subList);
            }
        }
    }


    // detect cycle in undirected graph
    public boolean isCycleUsingBfs(int V,ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i] && checkIfCycleUsingBfs(i,adjList, visited)){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfCycleUsingBfs(int src, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,-1});
        visited[src] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int parent = cur[1];
            for (int neighbour : adjList.get(node)) {
                if (neighbour == parent) continue;
                if (visited[neighbour]) return true;
                else {
                    queue.offer(new int[]{neighbour,node});
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }



    // cycle detection in undirected using dfs
    public boolean isCycleUsingDfs(int V,ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i] && checkIfCycleUsingDfs(i,-1,adjList, visited)){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfCycleUsingDfs(int src, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        for (int neighbour : adjList.get(src)) {
            if(neighbour == parent) continue;
            if(visited[neighbour]) return true;  //if not parent
            else{
                if(checkIfCycleUsingDfs(neighbour,src,adjList,visited)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCycleDirectedUsingDfs(int V,ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && checkCycleInDirected(i,visited,pathVisited,adjList)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCycleInDirected(int src, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjList) {
        visited[src] = true;
        pathVisited[src] = true;

        // dfs
        for (int neighbour : adjList.get(src)) {
            if(pathVisited[neighbour]) return true;
            else if (visited[neighbour]) continue;
            else {
                if (checkCycleInDirected(neighbour,visited,pathVisited,adjList)) return true;
            }
        }
        pathVisited[src] = false;
        return false;
    }


    // topological sort using kahn's algo
    public int[] topologicalSortKahnAlgorithm(int V,ArrayList<ArrayList<Integer>> adjList) {
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adjList.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbour : adjList.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (result.size() != V) {
            return new int[V];
        }
        int[] res = new int[V];
      for (int i = 0; i < V; i++) {
          res[i] = result.get(i);
      }
      return res;
    }

    public int[] topologicalSortDfs(int V,ArrayList<ArrayList<Integer>> adjList) {

        boolean[] visited = new boolean[V];
       Stack<Integer> stack = new Stack<>();

       for (int i = 0; i < V; i++) {
           if (!visited[i]) {
               dfsTopSort(i,visited,stack,adjList);
           }
       }
       int[] res = new int[V];
       int index = 0;
      while (!stack.isEmpty()) {
         res[index] = stack.pop();
         index++;
      }
      return res;

    }

    private void dfsTopSort(int src, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adjList) {
        visited[src] = true;
        for (int neighbour : adjList.get(src)) {
            if (!visited[neighbour]){
                dfsTopSort(neighbour,visited,stack,adjList);
            }
        }
        stack.push(src);
    }



    // detect cycle using topologicalSort
     // when final result is calculate
    // and if graph is directed and if topological sort is not happen
    // then reason is graph has cycle
    // so instead of return res
    // check if(res.size()!=V) return true;
    // else return false;




    // shortest path algo


    // 1. dijkstraAlgo
    public int[] dijkstraAlgo(int V,ArrayList<ArrayList<ArrayList<Integer>>> adjList,int S) {

        // pair -> ( node , distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int [] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S] = 0;
        pq.offer(new int[]{S,0});  // (node , dist)
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];
            if (dist[u] < d) continue;  // ignore if we have better answer
            for(ArrayList<Integer> neighbours : adjList.get(u)) {
                int v = neighbours.get(0);
                int w = neighbours.get(1);
                // relaxation
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        return dist;
    }



    // 2. flyod warshall

    public void FlyodWarshall(int[][] matrix) {
        // given is adj matrix
        // also matrix[i][j] == -1 mean no path so make to infinity like or greater than given constraints
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE/2;  // for e.g
                }
            }
        }

        // algo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // also ( optionally ) we can detect presence of -ve cycle
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                System.out.println("-ve cycle presence");
            }
        }

        // in - place things are done
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE/2) {
                    matrix[i][j] = -1; // again make it unreachable
                }
            }
        }
    }


    // 3 . bellman ford
    public int[] bellmanFord(int V,ArrayList<ArrayList<Integer>> edges,int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            boolean isChanged = false;
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if (dist[u]!= Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    isChanged = true;
                }
            }
            if (!isChanged) break;
        }

        // to detect -ve cycle
        // 1 more relaxation
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if (dist[u]!= Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("-ve cycle presence");
                return new int[]{};
            }
        }
        
        return dist;
    }


    //https://leetcode.com/problems/network-delay-time/
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0]-1;
            int v = time[1]-1;
            int w = time[2];
            adjList.get(u).add(new int[]{v,w});
        }
        int []minTime = dijkstraNetworkDelay(k-1,n,adjList);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < minTime.length; i++) {
            res = Math.max(res,minTime[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int[] dijkstraNetworkDelay(int src, int n, ArrayList<ArrayList<int[]>> adjList) {

        // pair -> ( node , distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int [] time = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[src] = 0;
        pq.offer(new int[]{src,0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];
            if(d > time[u]) continue;
            for (int [] neighbours : adjList.get(u)) {
                int v = neighbours[0];
                int w = neighbours[1];
                if (time[u] + w < time[v]) {
                   time[v] = time[u] + w;
                   pq.offer(new int[]{v,time[v]});
                }
            }
        }
        return time;
    }


    //https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] dist = new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src] = 0;
            for (int i = 0; i <k+1; i++) {
                int[] temp = Arrays.copyOf(dist,n);
                boolean isChanged = false;
                for (int[] edge : flights) {
                    int u = edge[0];
                    int v = edge[1];
                    int w = edge[2];
                    if (dist[u]!= Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                        temp[v] = dist[u] + w;
                        isChanged = true;
                    }
                }
               dist= temp;
                if (!isChanged) break;
            }

            return dist[dst]==Integer.MAX_VALUE? -1 : dist[dst];
    }


//https://leetcode.com/problems/minimum-cost-to-convert-string-i/
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] matrix = new int[26][26];
        int n = 26;

        // fill with infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( i==j) continue;  // skip diagonal so Zero always
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
           matrix[u][v] = Math.min(matrix[u][v],cost[i]);
        }

        // algo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if(matrix[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j <n; j++) {
                    if (matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dst = target.charAt(i) - 'a';
            if(matrix[src][dst] == Integer.MAX_VALUE) return -1;
            else result += (long)matrix[src][dst];
        }
        return result;
    }

}



