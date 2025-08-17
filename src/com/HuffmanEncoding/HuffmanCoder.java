package com.HuffmanEncoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String,Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;    // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public HuffmanCoder(String feeder)  throws  Exception{
        HashMap<Character,Integer> frequency=new HashMap<>();  //01
        //creating freq map   //02
        for (int i = 0; i < feeder.length(); i++) {
            char c=feeder.charAt(i);
            if (frequency.containsKey(c)){
                int v= frequency.get(c);
                v++;
                frequency.put(c,v);
            }else{
                frequency.put(c,1);
            }
        }
        //03
        Heap<Node> minHeap=new Heap<>();
        Set<Map.Entry<Character,Integer>> EntrySet= frequency.entrySet();  // for iterating convert freq to set;
        for(Map.Entry<Character,Integer> entry : EntrySet){
            Node node=new Node(entry.getKey(),entry.getValue());
            minHeap.insert(node);
        }

        //04
        while (minHeap.size()>1){
            Node first=minHeap.remove();
            Node second= minHeap.remove();
            Node newNode=new Node('\0', first.cost+second.cost);
            newNode.left=first;
            newNode.right=second;

            minHeap.insert(newNode);
        }
        Node ft=minHeap.remove();
        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();

        this.initEncoderDecoder(ft,"");

    }

    private void initEncoderDecoder(Node node, String osf) {  // output so far
        if(node==null ) return;

        if(node.left==null && node.right==null ) {
            // leaf node means find one character
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left, osf+"0");
        initEncoderDecoder(node.right, osf + "1");
    }



    public String encode(String source){
        String ans="";
        for (int i = 0; i <source.length() ; i++) {
            ans= ans + encoder.get(source.charAt(i));
        }
        return ans;
    }
    public String decode(String codeString){
    String key="";
    String ans="";
        for (int i = 0; i < codeString.length(); i++) {
            key=key + codeString.charAt(i);
            if(decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key= "";
            }
        }
        return ans;
    }
}
