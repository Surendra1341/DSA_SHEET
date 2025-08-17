package com.Maths;



//https://leetcode.com/problems/next-greater-element-iii
class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        // Step 1: Find the first decreasing pair from right to left
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such pair exists, return -1 (already the largest permutation)
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the smallest digit larger than digits[i] to the right of i
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap digits[i] and digits[j]
        swap(digits, i, j);

        // Step 4: Reverse the part of the array after index i to get the next smallest lexicographical order
        reverse(digits, i + 1, len - 1);

        // Convert the char array back to an integer and check if it's within the valid range
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int i, int j) {
        while (i < j) {
            swap(digits, i++, j--);
        }
    }
}
