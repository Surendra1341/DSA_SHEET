package com.OOPs.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son son=new Son(30);
        son.career();

        Daughter daughter=new Daughter(20);
        daughter.career();


        //we cannot create obj of abstract class
        //we cannot make static abstract class/method because abstract should be overridden and static cannot
        //here we call -> create a method hello() as static can call by parent.method();
        Parent.hello();
    }
}
