package com.Trees.Questions;

import com.Trees.Introduction.BinaryTree;

import java.util.*;

class DFS {

    //dfs using stack
    //preorder
    void DFS_Stack(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode current=stack.pop();
            System.out.println(current.val+ " ");
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
        }
    }

    //https://leetcode.com/problems/diameter-of-binary-tree
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //https://leetcode.com/problems/invert-binary-tree
    //post order
    public TreeNode invertTree(TreeNode node) {
        if (node == null) return null;
        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }


    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list
    // m1  space complexity o(N)
    /*
        public void flatten(TreeNode root) {
            if(root==null) return;
            Queue<TreeNode> queue=new LinkedList<>();
            preOrder(root,queue);
            TreeNode node=queue.poll();
        while (!queue.isEmpty()){
            node.left=null;
            node.right=queue.poll();
            node=node.right;
        }
    }
        private void preOrder(TreeNode node, Queue<TreeNode> queue) {
            if (node == null) return;
            queue.offer(node);
            preOrder(node.left,queue);
            preOrder(node.right,queue);
        }
    */

    //m2
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    //https://leetcode.com/problems/validate-binary-search-tree
    //in this what we do is we carry two val i.e
    // if go left mean high==current.val means value for lower left must be smaller then high
    // same if we go right side low==current.val mean value must me greater than low
    // also check both condition for every node and if low  ||  high == null don't  need check
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);
        return leftTree && rightTree;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int left = kthSmallest(root.left, k);
        if (left != 0) return left;
        count++;
        if (count == k) return root.val;
        return kthSmallest(root.right, k);

    }

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;

    }

    //https://leetcode.com/problems/path-sum
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }

    //https://leetcode.com/problems/sum-root-to-leaf-numbers
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    private int findSum(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) return sum;
        return findSum(node.left, sum) + findSum(node.right, sum);

    }
    //hard
    // similar to max. diameter one above all
    //https://leetcode.com/problems/binary-tree-maximum-path-sum
        int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = findMaxPathSum(node.left);
        int rightSum = findMaxPathSum(node.right);
        leftSum=Math.max(0,leftSum);
        rightSum=Math.max(0,rightSum);
        int currentSum = leftSum + rightSum + node.val;
       maxSum = Math.max(currentSum, maxSum);
       return node.val + Math.max(leftSum,rightSum);
    }


//Q1
    public Boolean isPathExist(TreeNode node,int[] arr){
        if(node==null) return arr.length==0;
        return isExist(node,arr,0);
    }

    private Boolean isExist(TreeNode node, int[] arr, int index) {
        if(node==null) return false;
        if(index>= arr.length || node.val!=arr[index]) return false;
        if(node.left==null && node.right==null && index==arr.length-1) return true;
        return isExist(node.left ,arr, index+1) ||  isExist(node.right ,arr, index+1);
    }

    //Q2

//    https://leetcode.com/problems/path-sum-iii/
    // long use kr
    public int countPath(TreeNode node,int sum){
        List<Integer> list=new LinkedList<>();
        return helperCountPath(node,sum,list);
    }

    private int helperCountPath(TreeNode node, int sum, List<Integer> path) {
        if(node==null){
            return 0;
        }
        path.add(node.val);
        int count=0;
        int currentSum=0;
        //how many path
        ListIterator<Integer> itr= path.listIterator(path.size());
        while(itr.hasPrevious()){
            currentSum+=itr.previous();

            if(currentSum==sum) count++;
        }
        count+=helperCountPath(node.left,sum,path) + helperCountPath(node.right,sum,path);
        //backtrack
        path.remove(path.size()-1);
        return count;
    }


    //https://leetcode.com/problems/find-mode-in-binary-search-tree/
    int maxFreq=0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new LinkedList<>();
        helperFindFrequency(root,map);
        //traverse map here
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if (entry.getValue() == maxFreq) list.add(entry.getKey());
        }
        return list.stream().mapToInt(i->i).toArray();

    }

    private void helperFindFrequency(TreeNode root, HashMap<Integer, Integer> map) {
        if(root==null) return;
        helperFindFrequency(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        maxFreq=Math.max(maxFreq,map.get(root.val));
        helperFindFrequency(root.right,map);
    }





    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }


    
}