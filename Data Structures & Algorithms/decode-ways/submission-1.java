class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(s, 0, dp);
    }

    private int decodeWays(String s, int idx, int[] dp) {
        if (idx >= s.length()) return 1;
        else if (s.charAt(idx) == '0') return 0;
        else if (dp[idx] != -1) return dp[idx];
        dp[idx] = decodeWays(s, idx+1, dp);

        if (idx < s.length() - 1 && Integer.parseInt(s.substring(idx, idx+2)) <= 26) {
            dp[idx] += decodeWays(s, idx+2, dp);
        } 

        return dp[idx];
    }
}
