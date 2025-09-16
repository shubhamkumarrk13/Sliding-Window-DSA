// Problem Link : https://leetcode.com/problems/permutation-in-string/description/

class Solution {

    public boolean check(int[] freq1, int[] freq2) {

        for(int i=0; i<26; i++) {

            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();

        int[] freq1 = new int[26];

        int[] freq2 = new int[26];

        for(int i=0; i<s1.length(); i++) {

            char ch = s1.charAt(i);

            freq1[ch - 'a']++;
        }

        int left = 0;

        int right = 0;

        while(right < s2.length()) {

            char ch = s2.charAt(right);

            freq2[ch - 'a']++;

            while((right - left + 1) > n) {

                char leftCh = s2.charAt(left);

                freq2[leftCh - 'a']--;

                left++;
            }

            if((right - left + 1) == n) {

                if(check(freq1, freq2)) return true;
            }

            right++;
        }

        return false;
        
    }
}
