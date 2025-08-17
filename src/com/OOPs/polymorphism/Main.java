package com.OOPs.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape=new Shapes();
        Circle circle= new Circle();
        Square square=new Square();

        circle.area();

        Shapes circle2=new Circle(); // here the type of method call depend on child class/obj type

    }
}
