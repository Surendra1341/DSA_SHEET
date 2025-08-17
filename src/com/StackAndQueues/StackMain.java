package com.StackAndQueues;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack=new CustomStack(5);
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(20);   // here because the stack get full it show "stack is full"

        System.out.println(stack.pop());   // pop return the items depend on generic chosen by you
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//       System.out.println(stack.pop());  // when we remove from an empty stack it will give error


        //dynamic stack
        CustomStack stack2=new DynamicStack(5);
//        DynamicStack stack2=new DynamicStack(5);    this both are same thing

        stack2.push(34);
        stack2.push(45);
        stack2.push(2);
        stack2.push(9);
        stack2.push(18);
        stack2.push(20);  //here it doubled the size
    }
}
