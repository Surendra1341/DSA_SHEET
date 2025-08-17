package com.StackAndQueues;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }
    @Override
    public boolean insert(int item){
        // this will care of its being full
        if(isFull()){
            // double the array size
            int[] temp=new int[data.length*2];
            //copy all previous item
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[(front +i)% data.length];
            }
            front=0;
            end=data.length;
            data=temp;  //here data is pointing to temp
            // and after copy temp will be out of scope & collected by garbage collector
            //i.e after it temp will not exist
        }
        // at this point array is not full
        //insert item;
        return super.insert(item);
    }
}
