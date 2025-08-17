package com.OOPs.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
         Human surendra=new Human(34,"surendra singh");
//         Human twin=new Human(surendra);

//        Human twin=(Human) surendra.clone();
//        System.out.println(twin.age + "  " + twin.name);
//
//        System.out.println(Arrays.toString(twin.arr));
//
//        twin.arr[0]=100;
//        //here surendra.arr also changes it is known as shallow copy
//
//        //for primitive it create  a new copy
//        // but for non - primitive(array,String..)  it point to same one
//        System.out.println(Arrays.toString(surendra.arr));



        // for this problem we use deep copy
                Human twin=(Human) surendra.clone();
        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0]=100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(surendra.arr));


    }
}
