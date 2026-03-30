class Solution {
    public int characterReplacement(String s, int k) {
        char[] charFreq = new char[26];
        int maxFreq = 0;
        int start = 0;
        int maxLength = 0;

        for (int end=0;end<s.length();end++) {
            charFreq[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[s.charAt(end) - 'A']);
            
            while (end-start+1-maxFreq > k) {
                charFreq[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}
