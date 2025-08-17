package com.OOPs.abstractDemo;

public class Son extends Parent{


    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("coder");
    }

    @Override
    void partner() {
        System.out.println("I love Iron man");
    }
}
