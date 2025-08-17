package com.OOPs.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a=5;
        int b=0;

        try {
//            int c=a/b;
//            divide(a,b);
            String name="surendra";
            if (name.equals("surendra")){
                throw new MyException("name is surendra");
            }
        }catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {           //it catch the message      we can add as much catch as  we want
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {                        // this will always run   *optional
            System.out.println("this will always execute");
        }

    }

     static int divide(int a,int b) throws ArithmeticException{
        if(b==0) {
            throw new ArithmeticException("plz do not divide by zero");
        }
        return a/b;
    }
}
