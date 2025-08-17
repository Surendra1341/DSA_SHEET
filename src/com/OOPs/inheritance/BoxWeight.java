package com.OOPs.inheritance;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);  //what is this? call the parent class constructor
        //use to initialise the values present in parent class
        this.weight = weight;

//        System.out.println(super.w);
//        here using super we can access the member of superclass we can also use this. but
//        let's take eg superclass also has variable weight then this.weight in subclass confuse so access superclass
//        member we gonna use super.member
    }
    public BoxWeight(BoxWeight old){
        super(old);   // not giving error  it exactly like Box box=new BoxWeight(2,3,4,5) read on main class
        weight=old.weight;
    }

    public BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }
}
