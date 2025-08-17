package com.OOPs.enumExamples;

public class Basic {

    enum Week implements A{
        Monday , Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        //these are enum constant
        //public,  static  and final
        //since it final we can't create child enums
//        type is week

        Week() {
            System.out.println("constructor called for " + this);
            //this is not public or protected , only private or default
            //why? we don't want to create new objects
            // because this is not an enum concept,that's why

            // internally : public static final Week Monday=new Week();
    }

        @Override
        public void hello() {
            System.out.println("hey how ae you");
        }
    }

    public static void main(String[] args) {
        Week week;
        week=Week.Monday;
        System.out.println(Week.valueOf("Monday"));
//        for (Week day: Week.values()){
//            System.out.print(day  + " ");
//        }
        week.hello();
    }
}
