package com.Trees.Questions;

import java.util.*;

public class MoreQuestionsAssignments {

    //https://leetcode.com/problems/binary-tree-inorder-traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helperInorder(root, list);
        return list;
    }

    private void helperInorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        helperInorder(node.left, list);
        list.add(node.val);
        helperInorder(node.right, list);
    }

    //https://leetcode.com/problems/same-tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //https://leetcode.com/problems/balanced-binary-tree
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return checkIsBalanced(root)!=-1;
    }

    private int checkIsBalanced(TreeNode node) {
        if (node==null) return 0;
       int left=checkIsBalanced(node.left);
       if(left==-1) return -1;   // normal check whether lower tree return -1 means lower left is unbalanced don' t check upper
       int right=checkIsBalanced(node.right);
       if (right==-1) return -1;     //similarly here
       if(Math.abs(left-right)>1) return-1;   // this is main condition where we check
        return Math.max(left, right) + 1;  // balancing height
    }

//https://leetcode.com/problems/minimum-depth-of-binary-tree
    public int minDepth(TreeNode node) {
        if(node==null) return 0;
      int left=minDepth(node.left);
      int right=minDepth(node.right);
      if(node.left==null && node.right==null) return 1;
      if(node.left==null) return right+1;
      if(node.right==null) return left+1;
      return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }


    //preorder
    //https://leetcode.com/problems/binary-tree-preorder-traversal
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list=new ArrayList<>();
        helperPreorder(node,list);
        return list;
    }
    private void helperPreorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        helperInorder(node.left, list);
        helperInorder(node.right, list);
    }

    //postorder
    //https://leetcode.com/problems/binary-tree-postorder-traversal
    public List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> list=new ArrayList<>();
        helperPostorder(node,list);
        return list;
    }
    private void helperPostorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        helperPostorder(node.left, list);
        helperPostorder(node.right, list);
        list.add(node.val);
    }

    //https://leetcode.com/problems/binary-tree-paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        String str="";
        findAllPaths(root,list,str);
        return list;
    }
    private void findAllPaths(TreeNode node, List<String> list, String str) {
        if (node==null) {
            return;
        }
        if(node.left==null && node.right==null) {
            list.add(str+node.val);
        }
        if(node.left!=null) findAllPaths(node.left,list,str+node.val+"->");
        if(node.right!=null) findAllPaths(node.right,list,str+node.val+"->");
    }

//https://leetcode.com/problems/sum-of-left-leaves
    public int sumOfLeftLeaves(TreeNode root) {
        return helperSumOfLeftLeaves(root,false);
    }

    private int helperSumOfLeftLeaves(TreeNode node,Boolean check) {
        if(node==null) return 0;
        if(node.left==null && node.right==null) {
            if(check) return node.val;
            else return 0;
        }
        int left= helperSumOfLeftLeaves(node.left,true);
        int right=helperSumOfLeftLeaves(node.right,false);
        return left+right;
    }

    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList<>();
        helperFindNode(root,target,k,list);
        return list;
    }

    private int helperFindNode(TreeNode node, TreeNode target, int k, List<Integer> list) {
        if(node==null) return -1;
        if(node.val== target.val){
            helperForSearching(node,k,list);
            return 0;
        }
        int left=helperFindNode(node.left,target,k,list);
        if(left!=-1){  // when lower part has found the ans
            if(1+left==k){
                //this case when 2 call back
                list.add(node.val);
            }
    helperForSearching(node.right,k-left-2,list);
            return 1+left;  //here update the upper calls
        }
        int right=helperFindNode(node.right,target,k,list);
        if(right!=-1){  // when lower part has found the ans
            if(1+right==k){
                //this case when  call back to parent
                list.add(node.val);
            }
            helperForSearching(node.left,k-right-2,list);
            return 1+right;  //here update the upper calls
        }
        return -1;
    }

    private void helperForSearching(TreeNode node, int k, List<Integer> list) {
        if (node == null || k < 0) return;
        if (k == 0) {
            list.add(node.val);
            return;
        }
        helperForSearching(node.left, k - 1, list);
        helperForSearching(node.right, k - 1, list);
    }

    //https://leetcode.com/problems/longest-univalue-path
        int max=0;
    public int longestUnivaluePath(TreeNode root) {
        findLength(root,root.val);
      return max;
    }

    private int findLength(TreeNode node, int val) {
        if(node==null) return 0;
        int left=findLength(node.left,node.val);
        int right=findLength(node.right,node.val);
        max=Math.max(max,left+right);
        if(val==node.val) return Math.max(left,right) +1;
        return 0;
    }


    //https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // Step 1: Perform an inorder traversal to get a sorted list of values
        List<Integer> sortedNodes = new ArrayList<>();
        inorderTraversal(root, sortedNodes);

        // Step 2: For each query, perform binary search to find the closest nodes
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            int left = findLeft(sortedNodes, query);
            int right = findRight(sortedNodes, query);
            result.add(Arrays.asList(left, right));
        }
        return result;
    }

    // Inorder traversal to get sorted node values
    private void inorderTraversal(TreeNode node, List<Integer> sortedNodes) {
        if (node == null) return;
        inorderTraversal(node.left, sortedNodes);
        sortedNodes.add(node.val);
        inorderTraversal(node.right, sortedNodes);
    }

    // Find the largest value <= query using binary search
    private int findLeft(List<Integer> sortedNodes, int query) {
        int left = 0, right = sortedNodes.size() - 1;
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedNodes.get(mid) <= query) {
                closest = sortedNodes.get(mid);
                left = mid + 1;  // Search for larger values
            } else {
                right = mid - 1;  // Search for smaller values
            }
        }
        return closest;
    }

    // Find the smallest value >= query using binary search
    private int findRight(List<Integer> sortedNodes, int query) {
        int left = 0, right = sortedNodes.size() - 1;
        int closest = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedNodes.get(mid) >= query) {
                closest = sortedNodes.get(mid);
                right = mid - 1;  // Search for smaller values
            } else {
                left = mid + 1;  // Search for larger values
            }
        }
        return (closest == Integer.MAX_VALUE) ? -1 : closest;
    }

    //https://leetcode.com/problems/linked-list-in-binary-tree
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // If the current root matches the linked list node, check the subtrees
        if (root.val == head.val) {
            // Check if we've matched the entire linked list starting from here
            if (isPath(head.next, root.left) || isPath(head.next, root.right)) {
                return true;
            }
        }
        // Otherwise, check the left and right subtrees with the same linked list head
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    private boolean isPath(ListNode head, TreeNode root) {
        if (head == null) return true;  // We've matched the whole linked list
        if (root == null) return false; // Tree is exhausted before linked list

        return root.val == head.val && (isPath(head.next, root.left) || isPath(head.next, root.right));
    }

    //https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree
    public boolean isValidSerialization(String preorder) {
     int slot=1;  // initially lets say there is one space for root;
        String[] arr=preorder.split(",");
        for(String str : arr){
            slot--; // by enter one slots filled
            if(slot<0) return false;
            if(!str.equals("#")) slot+=2;
        }
        return slot==0;
    }

    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;

        // Min-heap (PriorityQueue) to store top k largest sums
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);

        // BFS to calculate level sums
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long sum = 0;

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Insert the current level sum into the min-heap
            if (minHeap.size() < k) {
                minHeap.offer(sum);
            } else if (sum > minHeap.peek()) {
                minHeap.poll();  // Remove the smallest sum
                minHeap.offer(sum);  // Insert the new larger sum
            }
        }

        // If the heap contains fewer than k sums, return -1
        if (minHeap.size() < k) return -1;

        // The root of the min-heap contains the kth largest sum
        return minHeap.peek();
    }

    //https://leetcode.com/problems/maximum-product-of-splitted-binary-tree
    private long maxProd = 0;
    private final int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        int total = findSum(root);
        findMaxProduct(root, total);
        return (int) (maxProd % MOD);
    }

    private int findMaxProduct(TreeNode node, int total) {
        if (node == null) return 0;
        int left = findMaxProduct(node.left, total);
        int right = findMaxProduct(node.right, total);

        // Update maxProd with the product of the current subtree sum
        maxProd = Math.max(maxProd, (long) left * (total - left));
        maxProd = Math.max(maxProd, (long) right * (total - right));

        // Return the sum of the current subtree
        return left + right + node.val;
    }

    private int findSum(TreeNode root) {
        if (root == null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        return left + right + root.val;
    }


    //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
    public String getDirections(TreeNode root, int startValue, int destValue) {
        //  Find the LCA (lowest common ancestor) of startValue and destValue
        TreeNode lca = findLCA(root, startValue, destValue);

        // Find the path from LCA to startValue and LCA to destValue
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append("U");
        }

        // Append the remaining path from LCA to dest
        result.append(pathToDest);

        return result.toString();
    }

    // Function to find the LCA of startValue and destValue using a DFS approach
    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) return null;

        // If root matches either start or destination value, return root
        if (root.val == startValue || root.val == destValue) {
            return root;
        }

        // Search for the LCA in left and right subtrees
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        // If both subtrees return non-null, the current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right)
        return left != null ? left : right;
    }

    // Function to find the path from the LCA to the target value
    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) return false;

        // If current node is the target value, return true
        if (root.val == value) return true;

        // Try the left subtree and append "L" to the path
        path.append("L");
        if (findPath(root.left, value, path)) {
            return true;
        }

        // If not found in the left subtree, backtrack and try the right subtree
        path.deleteCharAt(path.length() - 1); // Remove the "L" and backtrack
        path.append("R");
        if (findPath(root.right, value, path)) {
            return true;
        }

        // If not found in either subtree, backtrack further
        path.deleteCharAt(path.length() - 1); // Remove the "R" and backtrack
        return false;
    }

}
