package com.OOPs.interfaceConcept.extendDemo2;

public class Main implements A,B {

    @Override
    public void greet() {

    }

    public static void main(String[] args) {
        //call via interface name
       A.greeting();
    }
}
