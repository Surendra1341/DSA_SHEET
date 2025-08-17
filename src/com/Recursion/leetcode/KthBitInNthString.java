package com.Recursion.leetcode;
/*
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x,
 and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
Example 1:
Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
 */

class KthBitInNthString {
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));  // Expected output: "1"
    }

    public static char findKthBit(int n, int k) {
        return findKthBitRecursive(n, k);
    }

    private static char findKthBitRecursive(int n, int k) {
        // Base case: the first string S(1) is "0"
        if (n == 1) {
            return '0';
        }

        // Length of the string S(n) is (2^n - 1)
        int length = (1 << n) - 1;  // This is 2^n - 1

        // If k is in the first half of S(n), it is equivalent to S(n-1)[k]
        if (k <= length / 2) {
            return findKthBitRecursive(n - 1, k);
        }

        // If k is the middle element, return "1"
        if (k == length / 2 + 1) {
            return '1';
        }

        // If k is in the second half, calculate the corresponding position in the inverted part
        // Inverted part corresponds to position (length - k + 1) in S(n-1)
        int newK = length - k + 1;
        char result = findKthBitRecursive(n - 1, newK);

        // The second half is the inverted string, so we flip the result
        return result == '0' ? '1' : '0';
    }
}
