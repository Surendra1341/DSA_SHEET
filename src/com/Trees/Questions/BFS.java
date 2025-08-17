package com.Trees.Questions;


import java.util.*;

class BFS {


    // bfs algorithm
    //102
    //https://leetcode.com/problems/binary-tree-level-order-traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            ans.add(currentLevel);
        }

        return ans;
    }

    //https://leetcode.com/problems/average-of-levels-in-binary-tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double average = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                average += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            average /= levelSize;
            ans.add(average);
        }
        return ans;
    }

    //find next Successor  : google
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            if (currentNode.val == key) break;
        }
        return queue.peek();
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean reverse = false;  //flag
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) queue.addLast(currentNode.left);
                    if (currentNode.right != null) queue.addLast(currentNode.right);
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) queue.addFirst(currentNode.right);
                    if (currentNode.left != null) queue.addFirst(currentNode.left);
                }
            }
            reverse = !reverse;   // changing reverse for different level
            ans.add(currentLevel);
        }

        return ans;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            ans.add(0, currentLevel);
        }

        return ans;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node
    public Node connect(Node root) {
        if (root == null) return null;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;    //connecting when shifting to next
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }


    //https://leetcode.com/problems/binary-tree-right-side-view
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) ans.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/symmetric-tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;   //if both are null we skip it
            if (left == null || right == null) return false;   //if any one is null
            if (left.val != right.val) return false;    // if value is not matched
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }


    //https://leetcode.com/problems/cousins-in-binary-tree
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = find(root, x);
        TreeNode yy = find(root, y);
        return ((level(root, x, 0) == level(root, y, 0)) && (!isSibling(root, xx, yy)));
    }

    private int level(TreeNode node, int x, int lev) {
        if (node == null) return 0;

        if (node.val == x) return lev;
        int l = level(node.left, x, lev + 1);
        if (l != 0) return l;
        return level(node.right, x, lev + 1);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) return false;
        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x) ||
                        isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    private TreeNode find(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;

        TreeNode n = find(node.left, x);
        if (n != null) return n;
        return find(node.right, x);
    }


    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        inorderTraversal(root); // Step 1: Flatten BST to sorted list

        for (int q : queries) {
            ans.add(findFloorAndCeil(q));
        }
        return ans;
    }


    //https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    private List<Integer> findFloorAndCeil(int target) {
        int floor = -1, ceil = -1;
        int low = 0, high = inorder.size() - 1;

        // Floor (largest <= target)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (inorder.get(mid) <= target) {
                floor = inorder.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = inorder.size() - 1;

        // Ceil (smallest >= target)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (inorder.get(mid) >= target) {
                ceil = inorder.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return Arrays.asList(floor, ceil);
    }


    

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}