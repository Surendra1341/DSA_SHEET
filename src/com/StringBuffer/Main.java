package com.StringBuffer;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // initially it has capacity of 16...
        //constructor 1
        StringBuffer sb =new StringBuffer();
//        System.out.println(sb.capacity());

        //constructor 2
        StringBuffer sb2 =new StringBuffer("Surendra Singh");

        //constructor 3       in this we can pass the capacity we want
        StringBuffer sb3 =new StringBuffer(30);
//        System.out.println(sb3.capacity());


//methods
        sb.append("WeMakeDevs");   // what ever you have in append will add on ...to original one  -> modify it
        sb.append(" is nice!");

        sb.insert(2," Surendra ");     // inserting at particular index

        sb.replace(2,12," Chintoo ");    //we can replace between [start,end)   here end is exclusive

        sb.delete(2,10);     // normal delete between index

        sb.reverse();
        sb.reverse();

        String str=sb.toString();
        System.out.println(str);

        //generating random string
        String name= RandomString.generate(20);
        System.out.println(name);


        //removing whitespaces
        String sentence=" f fe   eg w g fe w       f";
        System.out.println(sentence.replaceAll("\\s",""));   //here we replace all spaces with nothing


        //split
        String arr="Surendra uday Udit Ratan";
        String[] names=arr.split(" ");
        System.out.println(Arrays.toString(names));

        //rounding off
        DecimalFormat df=new DecimalFormat("0.0000");
        System.out.println(df.format(7.22347));


    }
}
