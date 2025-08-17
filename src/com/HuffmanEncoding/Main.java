package com.HuffmanEncoding;

public class Main {
    public static void main(String[] args)  throws Exception{
        String str="abbccda";
        HuffmanCoder coder= new HuffmanCoder(str);
        String encodedString = coder.encode(str);
        System.out.println(encodedString);

        String decodedString = coder.decode(encodedString);
        System.out.println(decodedString);

        //BitSet can be used : like an array but with a bit at every index
    }
}
