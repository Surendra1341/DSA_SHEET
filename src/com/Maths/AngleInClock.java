package com.Maths;
/*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
Answers within 10-5 of the actual value will be accepted as correct.

Example 1:
Input: hour = 12, minutes = 30
Output: 165
 */

class AngleInClock {
    public static void main(String[] args) {
        System.out.println(angleClock(3,15));
    }
    public static double angleClock(int hour, int minutes) {
        double angleByHour=(double) (hour + minutes/60.0)*30.0; // 30d per hour and calculated wrt 0.0
        double angleByMinutes=(double) (minutes*6.0); // 6d per min and calculated wrt 0.0
        double diff=Math.abs(angleByHour-angleByMinutes);
        if(diff>180.0){
            return 360.0-diff;
        }
        return diff;
    }
}