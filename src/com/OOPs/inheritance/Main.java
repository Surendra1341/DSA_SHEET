package com.OOPs.inheritance;

public class Main {
    public static void main(String[] args) {
//        Box box=new Box(4.2,3.9,9.2);
////        Box box2=new Box(box);
//        System.out.println(box.l+ " " + box.h + " " + box.w);

//           BoxWeight box3=new BoxWeight();
//        System.out.println(box3.l+ " "  + box3.weight);

//        Box box5=new BoxWeight(2,3,4,5);
//        System.out.println(box5.w);


        //there are many variables in both child and parent classes
        //you are given access to variable that are in the ref. type i.e BoxWeight
        //hence you should have access to weight variable
        //this also means,that you are trying to accessed should be initialised
        //but here ,when the obj itself is of type parent class,how will you call the constructor of child class
        //error
//        BoxWeight box6=new Box(2,3,4,5);  //error


        BoxPrice box=new BoxPrice(5,8,200);
    }
}
