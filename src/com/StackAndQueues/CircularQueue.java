package com.StackAndQueues;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    int front = 0;
    int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);   // this will  call the another constructor
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    // here a small change because to remove an item it takes O(n)
    // which is not good -> so a front ptr is used /
    // here only problem when let say end is at last position now if you remove from front
    // then front will ++ and after it if you try to insert an element just because end is at last position
    //we can't insert so  we have  to move end to 0th index so using end=end % lengthOfArray
    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty!!!");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public void display() {
        if(isEmpty()){
            System.out.println("empty!!");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i]+ " <- ");
            i++;
            i=i% data.length;
        }while(i!=end);
        System.out.println("END");
    }
}
