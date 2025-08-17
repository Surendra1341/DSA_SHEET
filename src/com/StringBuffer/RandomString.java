package com.StringBuffer;

import java.util.Random;

public class RandomString {
   static String generate(int size){
       // if we use normal string then str= str+ 1 time + 2 time ......
       // in string if we add random character it create new obj and the old object is keep in memory
       // for n size it has create n d/f string
       // so using string buffer

    StringBuffer sb=new StringBuffer(size);
       Random random=new Random();
       for (int i = 0; i < size; i++) {
           int randomChar=97 + (int)(26* random.nextFloat());
           sb.append((char)randomChar);
       }
       return sb.toString();
   }
}
