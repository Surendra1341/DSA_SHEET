package com.SlidingWindow_TwoPointer;

import java.util.*;

public class PracticeQuestion {


    //1
    // max  points u can obtain from k cards from start or end
//    https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    public int maxPointsFromCards(int[] cards,int k) {
        int lSum = 0;
        for(int i=0;i<k ;i++) lSum+=cards[i];
        int maxSum=lSum;
        int rSum=0;
        int n = cards.length;
        int rIndex= n-1;

        for(int i=k-1;i>=0;i--){

            lSum-=cards[i];
            rSum+=cards[rIndex];
            rIndex--;

            maxSum=Math.max(maxSum,lSum+rSum);

        }
        return maxSum;
    }

    //2
    //longest subString without repeating character
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int LongestSubStringWithoutRepeatChar(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0,r=0,max=0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r))>=l){
                     l = map.get(s.charAt(r))+1;
                }
            }

            int len = r - l + 1;
            max= Math.max(max,len);
            map.put(s.charAt(r),r);
            r++;  //expand
        }
        return max;
    }



    // 3
    //  max consecutive one III
    //https://leetcode.com/problems/max-consecutive-ones-iii/
    public int maxOnes(List<Integer> nums, int k) {
        int l=0,r=0,max=0,zeroes=0;
        while(r<nums.size()){
            if(nums.get(r)==0) zeroes++;

            if(zeroes>k){
                if(nums.get(l)==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                int len = r-l+1;
                max=Math.max(max,len);
            }
            r++;
        }
        return max;
    }


    // 4
    // fruit into basket
    public int fruitBasket(int[] arr){
        int l=0,r=0,max=0,k=2,n=arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);

            if(map.size()>k){
                map.put(arr[l],map.getOrDefault(arr[l],0)-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }

            if(map.size()<=k){
                max=Math.max(max,l-r+1);
            }
            r++;
        }
        return max;
    }


    // 5
    // longest subString  at most k distinct char
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
    public  int longestSubStringKDistinct(String s, int k) {
        int l=0,r=0,max=0,n=s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            if(map.size()>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }

            if(map.size()<=k){
                max=Math.max(max,l-r+1);
            }
            r++;
        }
        return max;
    }

    // no of subString(only a,b,c) containing all three character means a b c
    //https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    public int sunStringContainAllThree(String s){
        int ans=0,n=s.length();
        int[] lastSeen = {-1,-1,-1}; // 0-a,1-b,2-c
       for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                ans += 1 +Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            }
        }
       return ans;
    }


    //https://leetcode.com/problems/longest-repeating-character-replacement/description/
    public int characterReplacement(String s, int k) {
       int l=0,r=0,max=0,maxFreq=0;
       int[] hash = new int[26];
       while(r<s.length()){
           hash[s.charAt(r)-'A']++;
           maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);

           if( r-l+1 - maxFreq > k) {
               hash[s.charAt(l)-'A']--;
               l++;
           }

           if(r-l+1 - maxFreq <= k){
               max=Math.max(max,r - l + 1);
           }
           r++;
       }

        return max;
    }



    //https://leetcode.com/problems/binary-subarrays-with-sum/description/
    public int numSubarraysWithSum(int[] nums, int goal) {
       return helper(nums,goal) - helper(nums,goal-1);
    }

    public int helper(int []nums,int goal){
        if(goal<0){
            return 0;
        }
        int l=0,r=0,ans=0,temp=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]==1){
                temp++;
            }
            while(temp>goal){
                if(nums[l]==1){
                    temp--;
                }
                l++;
            }
            ans+=r - l + 1;
            r++;
        }
        return ans;
    }


    //https://leetcode.com/problems/count-number-of-nice-subarrays/description/
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }

    public int solve(int []nums,int goal){
        if(goal<0){
            return 0;
        }
        int l=0,r=0,ans=0,temp=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]%2==1){
                temp++;
            }
            while(temp>goal){
                if(nums[l]%2==1){
                    temp--;
                }
                l++;
            }
            ans+=r - l + 1;
            r++;
        }
        return ans;
    }


    



    

}
