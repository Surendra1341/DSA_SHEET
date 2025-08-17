package com.OOPs.polymorphism;

public class Circle extends Shapes{
    //this will run when obj of circle is created
    //hence it is fn overriding the parent method
    @Override //this is an annotation
    void area(){
        System.out.println("Area is pi*r*r");
    }
}
