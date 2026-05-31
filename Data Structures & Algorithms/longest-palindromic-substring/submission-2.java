class Solution {
    public String longestPalindrome(String s) {
        String maxString = "";

        for (int i=0;i < s.length();i++) {
            int[] startEnd = getPalindromeCount(s, i, i);
            if (startEnd[1] + 1 - startEnd[0] > maxString.length()) {
                maxString = s.substring(startEnd[0], startEnd[1]+1);
            }
            startEnd = getPalindromeCount(s, i, i+1);
            if (startEnd[1] + 1 - startEnd[0] > maxString.length()) {
                maxString = s.substring(startEnd[0], startEnd[1]+1);
            }
        }

        return maxString;
    }

    public int[] getPalindromeCount(String s, int start, int end) {
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return new int[]{start+1, end-1};
    }
}
