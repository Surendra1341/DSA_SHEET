package com.OOPs.generics.comparing;

public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return  marks + "";
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int) (this.marks - o.marks);
        return diff;

        // if diff==0 that means both are equal
        // if diff<0  that means o is bigger
        // if diff>0 that means o is lesser
    }
}
