package com.Trees.Questions;

public class BST_to_DDL {
    DLNode head;
    DLNode tail;
    public DLNode Convert(TreeNode root){
        if(root==null ) return  null;
        helper(root);
        return head;
    }

    private void helper(TreeNode node) {
        if(node==null) return;
        helper(node.left);
        //create
        DLNode newNode=new DLNode(node.val);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }

        helper(node.right);
    }
}

class DLNode {
    int val;
    DLNode next;
    DLNode prev;

    public DLNode(int val) {
        this.val = val;
    }
}
