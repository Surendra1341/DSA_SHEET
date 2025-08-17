package com.Trees.SegmentTree;

public class SegmentTree {

    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        // constructor
        //create a tree using array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {   //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval =[" + node.left.startInterval + "-" + node.left.endInterval + "] and Data: " + node.left.data + " => ";
        } else {
            str = str + "No left child => ";
        }

        // for current node
        str = str + "Interval =[" + node.startInterval + "-" + node.endInterval + "] and Data: " + node.data + " <= ";

        if (node.right != null) {
            str = str + "Interval =[" + node.right.startInterval + "-" + node.right.endInterval + "] and Data: " + node.right.data ;
        } else {
            str = str + " <= No right child";
        }
        System.out.println(str+ "\n");

        //call recursion
        if (node.left != null) display(node.left);
        if (node.right != null) display(node.right);
    }

    //query
    public int query(int start, int end) {
        return this.query(this.root, start, end);
    }

    private int query(Node node, int start, int end) {
        if (node.startInterval >= start && node.endInterval <= end) {
            //node is completely lying inside query
            return node.data;
        } else if (node.startInterval > end || start > node.endInterval) {
            //completely outside
            return 0;
        } else {
            return this.query(node.left, start, end) + this.query(node.right, start, end);
        }
    }
    public void update(int index,int value){
      this.root.data= update(this.root,index,value);
    }

    private int update(Node node, int index, int value) {
        if(index>=node.startInterval && index<= node.endInterval){
            if(index== node.startInterval && index==node.endInterval){
                node.data=value;
                return node.data;
            }else{
                int leftAns=this.update(node.left,index,value);
                int rightAns=this.update(node.right,index,value);
                node.data=leftAns+rightAns;
                return node.data;
            }
        }
            return node.data;

    }
}
