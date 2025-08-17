package com.StackAndQueues;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);   // this will  call the another constructor
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    // for inserting an element to array let say pointer ptr = -1; if you want to insert
    // then make ptr=ptr+1;   and  insert element
    // if you want to delete than delete the element at ptr  and then make ptr=ptr-1;

    public boolean push(int item){
        // basically in stack it return whether it is insert or not

        if(isFull()){
            System.out.println("Stack is full!!");
            return false;
        }

        ptr++;
        data[ptr]=item;
        return true;

    }
    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from empty stack");
        }
        //            int removed=data[ptr];
//            ptr--;
//            return removed;
        return data[ptr--];   // in simple
    }
    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from empty stack");
        }
        return data[ptr];
    }

    public boolean isFull() {
return ptr==data.length-1;  //ptr is at last index
    }
    public boolean isEmpty() {
        return ptr==-1;  //no item
    }
}
