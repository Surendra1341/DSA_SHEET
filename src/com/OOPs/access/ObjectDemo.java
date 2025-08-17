package com.OOPs.access;

public class ObjectDemo {
    int num;

    public ObjectDemo(int num) {
        this.num = num;
    }
    //discuss in hashmap lecture
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {  //when garbage collection is called
        super.finalize();
    }
}
