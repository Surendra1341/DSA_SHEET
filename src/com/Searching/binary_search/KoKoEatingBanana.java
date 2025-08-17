package com.Searching.binary_search;

class KoKoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        System.out.println(minEatingSpeed(piles, 1000000000));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;  // The smallest speed possible
        int end = piles[0];  // The largest pile size
        for (int i = 1; i < piles.length; i++) {
            if(piles[i]>end){
                end=piles[i];
            }
        }

        int ans = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;  // Try the middle speed
            // Calculate hours needed for speed = mid

            if (helper(piles, mid, h)) {
                ans = mid;

                end = mid ;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // Helper function to calculate the total hours needed to finish all piles at a given speed
    private static boolean helper(int[] piles, int speed, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += pile / speed;
            if (pile % speed != 0){
                totalHours+=1;
            }
        }
        if(totalHours>h) return false;
        return true;
    }
}