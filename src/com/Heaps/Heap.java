package com.Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap() {  // constructor
        this.list = new ArrayList<>();
    }
    private void swap(int first, int second){
        T temp= list.get(first);
        list.set(first, list.get(second));
        list.set(second,temp);
    }

    private int parent(int index) {
        return (index-1)/2;
    }
    private int left(int index){
        return index*2+1;
    }
    private int right(int index){
        return index*2+2;
    }
    public void insert(T value){
        list.add(value);  // first we insert it at last index
        upheap(list.size()-1);  // last index;
    }

    private void upheap(int index) {
        if(index==0) return;
        int p=parent(index);
        //if this condition hit then recursion call happen
        if(list.get(index).compareTo(list.get(p))<0){
            // parent is greater than child
            swap(index,p);
            upheap(p);
        }
    }
    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("can't remove from empty Heap!");
        }
        T temp=list.get(0);
        T last=list.remove(list.size()-1);
       if(!list.isEmpty()) list.set(0,last); // if not getting empty mean heap have only one value
        downHeap(0);
        return temp;
    }

    private void downHeap(int index) {
        int min=index;
        int left=left(index);
        int right=right(index);
        if(left< list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(left< list.size() && list.get(min).compareTo(list.get(left))>0){
            min=right;
        }
        if(min!=index) {
            swap(index,min);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }

}
