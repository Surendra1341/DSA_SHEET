package com.DynamicProgramming.MatrixChainMultiplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MCM {




    //Mcm recursive
    public int McmRecursive(int[] arr) {
        return solve(arr, 1, arr.length - 1);
    }

    private int solve(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solve(arr, i, k);
            int right = solve(arr, k + 1, j);
            int localCost = left + right + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, localCost);
        }
        return min;
    }

    // Mcm memo
    public int McmMemoized(int[] arr) {
        int[][] t = new int[arr.length][arr.length];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solveMemo(arr, 1, arr.length - 1, t);
    }

    private int solveMemo(int[] arr, int i, int j, int[][] t) {
        if (i >= j) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solveMemo(arr, i, k, t);
            int right = solveMemo(arr, k + 1, j, t);
            int cost = left + right + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }
        t[i][j] = min;
        return min;
    }

    //    https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
    //similar question
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] arr = new int[len + 2];
        arr[0] = 0;
        arr[len + 1] = n;
        System.arraycopy(cuts, 0, arr, 1, len);
        Arrays.sort(arr);
        int[][] t = new int[len + 2][len + 2];

        return solveMinCost(arr, 0, len + 1, t);
    }

    private int solveMinCost(int[] arr, int i, int j, int[][] t) {
        if (j - i <= 1) {
            return 0;
        }
        if (t[i][j] != 0) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int left = solveMinCost(arr, i, k, t);
            int right = solveMinCost(arr, k, j, t);
            int cost = arr[j] - arr[i] + left + right;
            min = Math.min(min, cost);
        }
        t[i][j] = min;
        return min;
    }


    //recursive + memo boolean parenthesis

    //palindrome Partitioning  recursive
    public int palindromePartitioning(String s) {
        return helperPalindromePartitioning(s, 0, s.length() - 1);
    }

    private int helperPalindromePartitioning(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + helperPalindromePartitioning(s, i, k) + helperPalindromePartitioning(s, k + 1, j);
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    // palindrome memo + optimized  -> hard Q ->TLE
    //https://leetcode.com/problems/palindrome-partitioning-ii
    public int palindromePartitioningMemo(String s) {
        int[][] t = new int[s.length() + 1][s.length() + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return helperPalindromePartitioningMemo(s, 0, s.length() - 1, t);
    }

    private int helperPalindromePartitioningMemo(String s, int i, int j, int[][] t) {
        if (i >= j || isPalindrome(s, i, j)) return 0;

        if (t[i][j] != -1) return t[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = (t[i][k] != -1) ? t[i][k] : helperPalindromePartitioningMemo(s, i, k, t);
            t[i][k] = left;

            int right = (t[k + 1][j] != -1) ? t[k + 1][j] : helperPalindromePartitioningMemo(s, k + 1, j, t);
            t[k + 1][j] = right;

            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }

        t[i][j] = min;
        return min;
    }





    static final int MOD = 1003;

    public static int booleanParenthesis(String s) {
//        return solveBooleanParenthesis(s,0,s.length()-1,true);   //recursive

        //memo
//        int n = s.length();
//        Integer[][][] t = new Integer[n][n][2]; // 0 -> false, 1 -> true
//        return solveBooleanParenthesisMemo(s, 0, n - 1, true, t);

        // using map
        return solveBooleanParenthesisUseMap(s, 0, s.length() - 1, true, new HashMap<>());
    }

    //recursive
    private static int solveBooleanParenthesis(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {

            int lt = solveBooleanParenthesis(s, i, k - 1, true);
            int lf = solveBooleanParenthesis(s, i, k - 1, false);
            int rt = solveBooleanParenthesis(s, k + 1, j, true);
            int rf = solveBooleanParenthesis(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                ans += isTrue ? lt * rt : lt * rf + rt * lf + rf * lf;
            } else if (s.charAt(k) == '|') {
                ans += isTrue ? lt * rf + rt * lf + lt * rt : rf * lf;
            } else if (s.charAt(k) == '^') {
                ans += isTrue ? lt * rf + rt * lf : rf * lf + lt * rt;
            }

        }
        return ans;
    }

    //memo boolean parenthesis
    private static int solveBooleanParenthesisMemo(String s, int i, int j,
                                                   boolean isTrue, Integer[][][] t) {
        if (i > j) return 0;

        int x = isTrue ? 1 : 0;
        if (t[i][j][x] != null) return t[i][j][x];

        if (i == j) {
            char c = s.charAt(i);
            int val = isTrue ? (c == 'T' ? 1 : 0) : (c == 'F' ? 1 : 0);
            return t[i][j][x] = val % MOD;
        }

        long ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            char op = s.charAt(k);

            int lt = solveBooleanParenthesisMemo(s, i, k - 1, true, t);
            int lf = solveBooleanParenthesisMemo(s, i, k - 1, false, t);
            int rt = solveBooleanParenthesisMemo(s, k + 1, j, true, t);
            int rf = solveBooleanParenthesisMemo(s, k + 1, j, false, t);

            long add = 0;
            if (op == '&') {
                add = isTrue ? (long) lt * rt
                        : (long) lt * rf + (long) lf * rt + (long) lf * rf;
            } else if (op == '|') {
                add = isTrue ? (long) lt * rt + (long) lt * rf + (long) lf * rt
                        : (long) lf * rf;
            } else if (op == '^') {
                add = isTrue ? (long) lt * rf + (long) lf * rt
                        : (long) lt * rt + (long) lf * rf;
            }

            ans = (ans + add) % MOD;
        }

        return t[i][j][x] = (int) ans;
    }

    // boolean paren.. using map -> dp
    private static int solveBooleanParenthesisUseMap(String s, int i, int j, boolean isTrue, HashMap<String, Integer> dp) {
        if (i > j) return 0;

        String key = i + "_" + j + "_" + isTrue;
        if (dp.containsKey(key)) return dp.get(key);

        if (i == j) {
            int val = isTrue ? (s.charAt(i) == 'T' ? 1 : 0) : (s.charAt(i) == 'F' ? 1 : 0);
            dp.put(key, val);
            return val;
        }

        long ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            char op = s.charAt(k);

            int lt = solveBooleanParenthesisUseMap(s, i, k - 1, true, dp);
            int lf = solveBooleanParenthesisUseMap(s, i, k - 1, false, dp);
            int rt = solveBooleanParenthesisUseMap(s, k + 1, j, true, dp);
            int rf = solveBooleanParenthesisUseMap(s, k + 1, j, false, dp);

            if (op == '&') {
                ans += isTrue ? (long) lt * rt : (long) lt * rf + (long) lf * rt + (long) lf * rf;
            } else if (op == '|') {
                ans += isTrue ? (long) lt * rt + (long) lt * rf + (long) lf * rt : (long) lf * rf;
            } else if (op == '^') {
                ans += isTrue ? (long) lt * rf + (long) lf * rt : (long) lt * rt + (long) lf * rf;
            }

            ans %= MOD;  // Only if MOD needed
        }

        dp.put(key, (int) ans);
        return (int) ans;
    }


    // scramble String
    //https://leetcode.com/problems/scramble-string/
    public boolean scrambleString(String a, String b) {
        if (a.length() != b.length()) return false;
        if (!sameFreq(a, b)) return false;
//        return solveScrambleString(a, b);   //recursive approach

        // memo approach

        return solveScrambleStringMemo(a,b,new HashMap<>());
    }
    private boolean sameFreq(String x, String y) {
        int[] cnt = new int[26];              // if only lowercase letters; else use 256
        for (int i = 0; i < x.length(); i++) {
            cnt[x.charAt(i) - 'a']++;
            cnt[y.charAt(i) - 'a']--;
        }
        for (int c : cnt) if (c != 0) return false;
        return true;
    }


    //recursive
    private boolean solveScrambleString(String a, String b) {
        //base condition
        if (a.isEmpty() || b.isEmpty()) return true;
//        if(a.compareTo(b) == 0) return true;
        if (a.equals(b)) return true;

        int n = a.length();
        if (n <= 1) return false;

        boolean flag = false;
        for (int i = 1; i < n; i++) {
            // 2 cases

            // Swap case
            if (solveScrambleString(a.substring(0, i), b.substring(n - i, n)) &&
                    solveScrambleString(a.substring(i, n), b.substring(0, n - i))) {
                flag = true;
                break;
            }

            // No swap case
            if (solveScrambleString(a.substring(0, i), b.substring(0, i)) &&
                    solveScrambleString(a.substring(i, n), b.substring(i, n))) {
                flag = true;
                break;

            }
        }
        return flag;
    }

    //memo and some optimization
    private boolean solveScrambleStringMemo(String a, String b, Map<String,Boolean> dp) {
        //base condition
        if (a.equals(b)) return true;

        int n = a.length();

        if( n <= 1) return false;


        String key = a + "_" + b;
        if (dp.containsKey(key)) return dp.get(key);

        if (!sameFreq(a, b)){
            dp.put(key, false);
            return false;
        }

        boolean flag = false;
        for (int i = 1; i < n; i++) {
            // 2 cases

            // Swap case
            if (solveScrambleStringMemo(a.substring(0, i), b.substring(n - i, n),dp) &&
                    solveScrambleStringMemo(a.substring(i, n), b.substring(0, n - i),dp)) {
                dp.put(key, true);
                return true;
            }

            // No swap case
            if (solveScrambleStringMemo(a.substring(0, i), b.substring(0, i),dp) &&
                    solveScrambleStringMemo(a.substring(i, n), b.substring(i, n),dp)) {
                dp.put(key, true);
                return true;

            }
        }
        dp.put(key, false);
        return false;
    }


    // egg drop problem
    //https://leetcode.com/problems/super-egg-drop/description/
    public int eggDrop(int e, int f) {
        // recursive
//        return solveEggDrop(e,f);

        // memo
//        int[][] t = new int[e+1][f+1];
//        for(int[] row : t) Arrays.fill(row, -1);
//        return solveEggDropMemo(e,f,t);

        //optimize -> binary search
        int[][] t = new int[e+1][f+1];
        for(int[] row : t) Arrays.fill(row, -1);
        return solveEggDropBS(e,f,t);
    }


    private int solveEggDrop(int e, int f) {
        if(e==1 || f==1) return f;

        int ans = f;
        for (int k = 1; k <= f; k++) {
            int temp =  1+ Math.max(solveEggDrop(e-1,k-1), solveEggDrop(e,f-k));
            ans = Math.min(ans, temp);
        }
        return ans;


    }

    private int solveEggDropMemo(int e, int f, int[][] t) {
        if(e==1 || f==1) return f;
        if(t[e][f]!=-1) return t[e][f];
        int ans = f;
        for (int k = 1; k <= f; k++) {
            int temp =  1+ Math.max(solveEggDropMemo(e-1,k-1,t), solveEggDropMemo(e,f-k,t));
            ans = Math.min(ans, temp);
        }
        t[e][f] = ans;
        return ans;
    }

    private int solveEggDropBS(int e, int f, int[][] t) {
        if(e==1 || f==1) return f;
        if(t[e][f]!=-1) return t[e][f];

        int start=1,end=f,ans=f;
        while(start<=end) {
            int mid = start+(end-start)/2;

            int broken =t[e-1][mid-1]!=-1 ? t[e-1][mid-1] : solveEggDropBS(e-1,mid-1,t);
            int notBroken = t[e][f-mid]!=-1 ? t[e][f-mid] :solveEggDropBS(e,f-mid,t);

            int temp = 1 + Math.max(broken, notBroken);
            ans = Math.min(ans, temp);

            if (broken < notBroken) {
                start = mid + 1;
            } else {
                end = mid - 1;      // go lower
            }
        }
        return t[e][f] = ans;

    }




}



