package com.Recursion.leetcode;

class LetterTIlePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i = 0; i < tiles.length(); i++) {
            freq[tiles.charAt(i) - 'A']++;
        }
        return backTrack(freq);
    }

    private int backTrack(int[] freq) {
        int count=0;
        for(int i=0; i<26; i++) {
            if(freq[i]>0) {
                count++;
                freq[i]--;
                count+=backTrack(freq);
                freq[i]++;
            }
        }
        return count;
    }
}