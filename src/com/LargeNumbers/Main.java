package com.LargeNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[]  args){
//     BI();
     BD();


    }

    private static void BD() {
//        double x=0.03;
//        double y=0.04;
//        System.out.println(y-x);  // giving some error 10^-19
//

        //so
//        BigDecimal X=new BigDecimal("0.03");
//        BigDecimal Y=new BigDecimal("0.04");
//        BigDecimal sub=Y.subtract(X);
//        System.out.println(sub);

        BigDecimal a=new BigDecimal("53355.242342424");
        BigDecimal b= new BigDecimal("59855849459595.35395935059294954929");
        //operations
        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));
    }

    static void BI(){
        int a=30;
        int b=67;
        BigInteger A=BigInteger.valueOf(33);     //here in this we convert int/long   -> big integer
        BigInteger B=BigInteger.valueOf(340192125);   // here value_of method is static so we cn use it through class.fun_name
        BigInteger C=new BigInteger("2247626436534478832848");   // this one is constructor we can pass very big no. as string
        BigInteger X=new BigInteger("5249329492491588988328");

        // similarly if we convert bigInteger to int
        int c=B.intValue();  //  bigInteger  to int

        //constant
        BigInteger D=BigInteger.ONE;   //ZERO    TEN .......  read from documentation

        //calculations
        BigInteger s= C.add(X);     // because  C and X are object we cannot directly add like C + X   >>
        System.out.println(s);
        BigInteger m= C.multiply(X);
        System.out.println(m);
        BigInteger d=C.divide(X);
        System.out.println(d);
        BigInteger sub=C.subtract(X);
        System.out.println(sub);
        BigInteger rem=C.remainder(X);
        System.out.println(rem);

        //compare
        if(C.compareTo(X)<0){
            System.out.println("yes");
        }

        System.out.println(Factorial.fact(100));    //very very big
    }
}
