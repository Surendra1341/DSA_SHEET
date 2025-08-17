package com.Hashmaps;

public class KarpRabin {
    private final int  PRIME=101;

    // in this fn we generate a hash code may be very big
  private double calculateHash(String str){
      double hash=0;
      for (int i = 0; i <str.length(); i++) {
        hash= (double) (hash+ str.charAt(i)*Math.pow(PRIME , i));
      }
        return hash;
  }
   private double updateHash(double prevHash ,char oldChar, char newChar, int patternLength){
       double newHash =(prevHash - oldChar) /PRIME;
      newHash = (double) (newHash + newChar * Math.pow(PRIME , patternLength-1));
      return newHash;
   }
   public void  search(String text, String pattern){
      int patternLength= pattern.length();
       double patternHash= calculateHash(pattern);
       double textHash=calculateHash(text.substring(0,patternLength));
       for (int i = 0; i <= text.length() - patternLength; i++) {
           if(textHash == patternHash){
               if(text.substring(i,patternLength+i).equals(pattern)){
                   System.out.println("pattern found at index : "+ i);
               }
           }
           if(i < text.length() - patternLength){
               textHash= updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
           }
       }
   }

}
