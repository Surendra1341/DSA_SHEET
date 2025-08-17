package com.DynamicProgramming.LCS;

public class LCS_question {

    static int[][] t;

    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
//        System.out.println(lcsRecursive(x,x.length(),y,y.length()));

        t = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                t[i][j] = -1;
            }
        }
//        System.out.println(lcsRecursiveAndMemoization(x,x.length(),y,y.length()));


//         System.out.println(lcsTopDown(x,x.length(),y,y.length()));
//        System.out.println(printLCS(x, x.length(), y, y.length()));


        System.out.println(printSCS(x, x.length(), y, y.length()));

    }

    //lcs recursive
    public static int lcsRecursive(String X, int n, String Y, int m) {
        //base condition
        if (n == 0 || m == 0) return 0;

        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            return lcsRecursive(X, n - 1, Y, m - 1) + 1;
        }
        //else
        return Math.max(lcsRecursive(X, n - 1, Y, m), lcsRecursive(X, n, Y, m - 1));

    }

    //lcs dp
    public static int lcsRecursiveAndMemoization(String X, int n, String Y, int m) {
        if (n == 0 || m == 0) return 0;

        if (t[n][m] != -1) return t[n][m];

        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            t[n][m] = lcsRecursiveAndMemoization(X, n - 1, Y, m - 1) + 1;
            return t[n][m];
        }
        //else
        t[n][m] = Math.max(lcsRecursiveAndMemoization(X, n - 1, Y, m), lcsRecursiveAndMemoization(X, n, Y, m - 1));
        return t[n][m];
    }

    // lcs top down
//https://leetcode.com/problems/longest-common-subsequence/description/
    public static int lcsTopDown(String X, int n, String Y, int m) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) t[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][m];
    }

    //longest common substring
    public static int longestCommonSubString(String X, int n, String Y, int m) {
        int[][] t = new int[n + 1][m + 1];
        //initialization same
        // if(n==0 || m==0) t[i][j]=0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) t[i][j] = 1 + t[i - 1][j - 1];
                else t[i][j] = 0;
            }
        }
        return t[n][m];
    }


    // print lcs
    public static String printLCS(String X, int n, String Y, int m) {

        int[][] t = new int[n + 1][m + 1];
        //same initialization


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) t[i][j] = 1 + t[i - 1][j - 1];
                else t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        int i = n, j = m;
        StringBuilder result = new StringBuilder();
        while (i > 0 || j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) i--;
                else j--;
            }
        }
        return result.reverse().toString();
    }



    // shortest common SuperSequence
    public static int  shortestCommonSuperSequence(String X, int n, String Y, int m) {
        int common=lcsTopDown(X, n, Y, m);  // length of lcs
        return n+m-common;
    }


    //min. no. insertion and deletion for a-->b
    public static int insertionAndDeletion(String X, int n, String Y, int m) {
        int common=lcsTopDown(X, n, Y, m); // lcs length

        return (n-common) + (m-common);
    }


    // longest palindromic subsequence
//https://leetcode.com/problems/longest-palindromic-subsequence/
    public static int longestPalindromicSubsequence(String S) {
        int len = S.length();
        StringBuilder sb=new StringBuilder(S);
        return lcsTopDown(S,len,sb.reverse().toString(),len);
    }

    //min. no. of deletion in a String to make it palindromic
    public static int MinDeletionPalindrome(String S) {
        int lps= longestPalindromicSubsequence(S);
        return (S.length() - lps);  //  min no. of deletion
    }

    //print shortest common supersSequence
    public static String printSCS(String X, int n, String Y, int m){


        int[][] t = new int[n + 1][m + 1];
        //same initialization


        //making lcs table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) t[i][j] = 1 + t[i - 1][j - 1];
                else t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        // finding ans
        int i = n, j = m;
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]){
                    result.append(X.charAt(i - 1));
                    i--;
                } else{
                    result.append(Y.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i >0) {
            result.append(X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(Y.charAt(j - 1));
            j--;
        }
        return result.reverse().toString();
    }



    // longest repeat Subsequence
    public static int longestRepeatSubsequence(String X, int n, String Y, int m) {


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)  && i!=j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n][m];
    }

    // sequence pattern matching
    public static boolean sequencePatternMatching(String a,String b) {
        int lcs = lcsTopDown(a,a.length(),b,b.length());
        return lcs==a.length();
    }



    //min. no. of insertion in a String to make it palindromic
    //https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    public static int MiniInsertionPalindrome(String S) {
        int lps= longestPalindromicSubsequence(S);
        return (S.length() - lps);  //  min no. of insertion
    }

}
