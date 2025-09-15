// Problem Link : https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int maxLen = 0;

        int maxFreq = 0;

        int left = 0;

        int right = 0;

        while(right < s.length()) {

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;

                maxFreq = 0;

                for(int i=0; i<26; i++) maxFreq = Math.max(maxFreq, freq[i]);

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
        
    }
}
