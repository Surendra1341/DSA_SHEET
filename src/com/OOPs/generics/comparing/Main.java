package com.OOPs.generics.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student surendra=new Student(1, 87.2f);
        Student rahul=new Student(30, 73.8f);
        Student arpit=new Student(12, 45.3f);
        Student karan=new Student(45, 13.4f);
        Student sachin=new Student(19, 67.5f);

        //        if (surendra > rahul){
//            this is not right way
//        }
//        if(surendra.compareTo(rahul)>0){
//            System.out.println("surendra has more marks");
//        }

        Student[] list={surendra,rahul,arpit,karan,sachin};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);   //here comparing marks
        System.out.println(Arrays.toString(list));

           //m2
//        Arrays.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int) (o1.marks - o2.marks);   //sort in ascending order
//            }
//        });
//        System.out.println(Arrays.toString(list));





    }
}
