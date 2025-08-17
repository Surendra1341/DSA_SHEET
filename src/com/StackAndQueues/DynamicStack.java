package com.StackAndQueues;

public class DynamicStack  extends CustomStack{   // because we have already many work;


    public DynamicStack() {
        super();  //it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size);   //it will call CustomStack(int size)
    }

    // in CustomStack the only one problem we phase when we have insert more element
    //except all things are same
    // so we have to override  push fun
    @Override
    public boolean push(int item){
        // this will care of its being full
        if(isFull()){
            // double the array size
            int[] temp=new int[data.length*2];

            //copy all previous item
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[i];
            }
            data=temp;  //here data is pointing to temp
            // and after copy temp will be out of scope & collected by garbage collector
            //i.e after it temp will not exist
        }

        //insert item;
        return super.push(item);
    }
}
