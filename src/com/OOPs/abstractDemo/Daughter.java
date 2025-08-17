package com.OOPs.abstractDemo;

public class Daughter extends Parent {


    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Doctor");
    }

    @Override
    void partner() {
        System.out.println("I love captain marvel" );
    }
}
