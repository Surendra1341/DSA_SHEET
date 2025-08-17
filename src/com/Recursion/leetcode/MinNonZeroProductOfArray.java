package com.Recursion.leetcode;

import java.math.BigInteger;

class MinNonZeroProductOfArray {
    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        BigInteger MOD = BigInteger.valueOf(1_000_000_007);
        BigInteger max = BigInteger.ONE.shiftLeft(p).subtract(BigInteger.ONE); // 2^p - 1
        BigInteger base = max.subtract(BigInteger.ONE); // 2^p - 2
        BigInteger power = max.subtract(BigInteger.ONE).divide(BigInteger.TWO); // (2^p - 2)/2

        BigInteger res = base.modPow(power, MOD).multiply(max).mod(MOD);
        return res.intValue();
    }
    //the logic original but fail for p=35
    /*
    public int minNonZeroProduct(int p) {
         if (p == 1) return 1;
        long MOD = 1000_000_000 + 7;
        long max= (1L<<p)-1; //fast
        long powerResult=expo(max-1,(max-1)/2,MOD);
        long res= (powerResult*max)%MOD;
        return (int)(res);
    }
    private long  expo(long base, long power,long MOD) {
       if(power==0) return 1;
       long temp = expo(base,power/2,MOD);
       long p =(temp*temp)%MOD;
       return power%2==1 ? ( p * (base%MOD))%MOD : p;
    }
    */
}