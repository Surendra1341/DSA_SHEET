package com.Trees.Questions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//hard
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree
public class SerializeAndDeserialize {
    public String serialize(TreeNode node){
      StringBuffer str=new StringBuffer();
        helper(node,str);
        return str.toString();
    }

    private void helper(TreeNode node, StringBuffer str) {
        if (node==null){
            str.append("n");
            str.append(",");
            return;
        }
      str.append(node.val);
        str.append(",");
        helper(node.left,str);
        helper(node.right,str);
    }

    public TreeNode deserialize(String data){
        List<String> list=new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(list);
        TreeNode node=helper2(list);
        return node;
    }

    private TreeNode helper2(List<String> list) {
        String val=list.remove(list.size()-1);
        if(val.charAt(0)=='n') return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=helper2(list);
        node.right=helper2(list);
        return node;
    }
}
