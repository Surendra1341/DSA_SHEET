package com.Trees.Questions;

import java.util.*;
import java.util.AbstractMap;
import java.util.stream.Collectors;

public class AdvanceTreeQuestions {


//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

    //m1
     /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        TreeNode node=new TreeNode(preorder[0]);

        int index=0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[0]) break;
            index++;
        }
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
*/
    //m2
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] index={0};
        return helperBuildTree(preorder, inorder, 0, preorder.length - 1, map,index);
    }

    private TreeNode helperBuildTree(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map,int[] index) {
        if (left > right) return null;
        int current = preorder[index[0]];
        index[0]++;
        TreeNode node = new TreeNode(current);
        if(left==right) return node;
        int inOderIndex= map.get(current);
        node.left = helperBuildTree(preorder, inorder, left, inOderIndex - 1, map,index);
        node.right = helperBuildTree(preorder, inorder,  inOderIndex+1, right, map,index);
        return node;
    }

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
    //hard
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;

            // Map to hold the column index and a list of nodes (value, depth)
            Map<Integer, List<int[]>> map = new HashMap<>();
            Queue<Triple<TreeNode, Integer, Integer>> queue = new LinkedList<>();
            queue.offer(new Triple<>(root, 0, 0)); // (node, column, depth)

            int minCol = 0, maxCol = 0;

            while (!queue.isEmpty()) {
                Triple<TreeNode, Integer, Integer> entry = queue.poll();
                TreeNode node = entry.node;
                int col = entry.col;
                int depth = entry.depth;

                if (node != null) {
                    // Add the node's value and depth to the map
                    map.putIfAbsent(col, new ArrayList<>());
                    map.get(col).add(new int[]{node.val, depth});

                    // Update the min and max column indices
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);

                    // Add children to the queue with updated column and depth
                    queue.offer(new Triple<>(node.left, col - 1, depth + 1));
                    queue.offer(new Triple<>(node.right, col + 1, depth + 1));
                }
            }

            // Process the map to create the result
            for (int i = minCol; i <= maxCol; i++) {
                if (map.containsKey(i)) {
                    List<int[]> nodes = map.get(i);
                    // Sort by depth first, then by value
                    Collections.sort(nodes, (a, b) -> {
                        if (a[1] != b[1]) {
                            return Integer.compare(a[1], b[1]); // Sort by depth
                        } else {
                            return Integer.compare(a[0], b[0]); // Sort by value
                        }
                    });

                    // Extract the sorted values
                    List<Integer> sortedValues = new ArrayList<>();
                    for (int[] node : nodes) {
                        sortedValues.add(node[0]);
                    }
                    result.add(sortedValues);
                }
            }

            return result;
        }
    // Helper class to hold node, column, and depth
    private static class Triple<T, U, V> {
        T node;
        U col;
        V depth;

        Triple(T node, U col, V depth) {
            this.node = node;
            this.col = col;
            this.depth = depth;
        }
    }

    //hard
    //https://leetcode.com/problems/word-ladder
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> wordSet = new HashSet<>(wordList); // Convert wordList to a Set for faster lookups
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        visited.add(beginWord); // Add beginWord to visited to avoid revisiting

        int length = 1; // We start with length 1 as we count the beginWord itself
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Try changing each letter of the word to all possible characters
                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    char originalChar = temp[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue; // Skip same character

                        temp[j] = ch;
                        String newWord = new String(temp);

                        // If we find the endWord, return the result
                        if (newWord.equals(endWord)) return length + 1;

                        // If the new word is valid and not visited, add it to the queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord); // Mark this word as visited
                        }
                    }
                }
            }
            length++; // Increment the length after processing one level of BFS
        }

        return 0; // If no path is found, return 0
    }


//https://leetcode.com/problems/two-sum-iv-input-is-a-bst
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
       return helperFindTarget(root,k,set);

    }

    private boolean helperFindTarget(TreeNode root, int k ,HashSet<Integer> set) {
        if(root==null) return false;
       if(set.contains(k-root.val)) return true;
       set.add(root.val);
       return  helperFindTarget(root.left,k,set) ||  helperFindTarget(root.right,k,set);
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst
    public int kthSmallest(TreeNode root, int k) {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    helperKthSamllest(root,minHeap);
    int ans=0;
        for (int i = 0; i < k; i++) {
            ans=minHeap.poll();
        }
        return ans;
    }

    private void helperKthSamllest(TreeNode node, PriorityQueue<Integer> minHeap) {
        if(node==null) return;
        helperKthSamllest(node.left,minHeap);
        minHeap.offer(node.val);
        helperKthSamllest(node.right,minHeap);
    }


//two node Swap  69
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void  helper(TreeNode root){
        iot(root);
        // swap
        int temp= first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void iot(TreeNode node) {
        if(node==null) return;
        iot(node.left);

        if(prev!=null && prev.val > node.val){
            if(first==null) first=prev;
             second = node;
        }
        iot(node.right);
    }


}

