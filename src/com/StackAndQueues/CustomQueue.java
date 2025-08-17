package com.StackAndQueues;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);   // this will  call the another constructor
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    //here the small difference is first we insert then increase the end by 1;
    //for removing end -1 then remove element

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    //now if you remove item it should remove the first item(FIFO) so
    //here what we do is replace 1 with 2 & 2 with 3 & 3 with 4 .......<end   and end-1 in the last
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!!!");
        }
        int removed = data[0];
        //shift the element left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!!!");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}
