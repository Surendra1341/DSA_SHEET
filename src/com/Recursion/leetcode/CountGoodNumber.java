package com.Recursion.leetcode;

class CountGoodNumber {
    static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long res =(expo(5,even)*expo(4,odd))%MOD;
        return (int)res;
    }

    private long  expo(long base, long power) {
        long res = 1;
        base %=MOD;
        while(power > 0) {
            if((power & 1)==1)
                res = (res * base) % MOD;

            base = (base * base) % MOD;
            power >>= 1;
        }
        return res;
    }


    //m1
//    public int countGoodNumbers(long n) {
//        long even = (n + 1) / 2; // even indices
//        long odd = n / 2;        // odd indices
//        long res = (modPow(5, even, MOD) * modPow(4, odd, MOD)) % MOD;
//        return (int) res;
//    }
//
//    private long modPow(long base, long exp, int mod) {
//        long result = 1;
//        base %= mod;
//        while (exp > 0) {
//            if ((exp & 1) == 1)
//                result = (result * base) % mod;
//            base = (base * base) % mod;
//            exp >>= 1;
//        }
//        return result;
//    }
}
