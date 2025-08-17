package com.OOPs.Introduction;

public class Wrapper_example {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        Integer num = 10;
        //    Integer num = new Integer(10);   constructor
        // now num is obj you can use dot operation

        swap1(a, b);  //it will not swap original
        // in java not anything like pass by reference only pass by value
        System.out.println(a + " " + b);

        // but when you pass obj then reference value is passed
        Integer c=10;
        Integer d=20;
        swap2(c,d);  // here also no swapping Integer is class of type Final
        System.out.println(c+ " " +d);
        // final is keyword so that you content cannot  be modified
        // convection final int INCREASE(all capital)=2;

        final int bonus=2;
//        bonus=3;  it give me error you can't modified it
        // since always initialise it when you declare compulsory

        // but this immutability only hold for primitive data type

      final  A student=new A("surendra singh");
      // here i can do this  we can change the value
        student.name="other name";

        //when a non primitive is final oyu cannot reassign it.
//        student=new A("new obj");   this give me error
        
        // finalise concept

        // we don't do it manually  here we initialize many time so final say obj is destroy and garbage collector
        // collect the old one's
        A obj;
        for (int i = 0; i < 1000000000; i++) {
            obj = new A("random name");
        }
        //here in first time obj point to first then loop again work it point to second then third ... forth .. fifth
        // and the garbage collector collect the previous one
    }


    private static void swap1(int a, int b) {  //here the a and b are not the original one they are copy and swap in only in this scope
        int temp = a;
        a = b;
        b = a;
    }
    private static void swap2(Integer c, Integer d) {
        Integer temp=c;
        c=d;
        d=temp;
    }
}
class A {
    String name;

    // trick to create a constructor (alt+insert)
    public A(String name) {
        this.name = name;
    }
// in java obj is being destroyed manually when work is done
    // so a method i.e finalize is created and we say do this before destroy
    //basically you can't destroy but  you can do what to do when destroy
    @Override
    protected void finalize() throws Throwable {
        System.out.println("obj is destroyed");
    }
}
