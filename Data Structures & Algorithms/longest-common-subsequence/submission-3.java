class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getLength(text1, text2, text1.length()-1, text2.length()-1, dp);
    }

    private int getLength(String text1, String text2, int idx1, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) return 0;
        else if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + getLength(text1, text2, idx1-1, idx2-1, dp);
            return dp[idx1][idx2];
        }

        dp[idx1][idx2] = Math.max(getLength(text1,text2, idx1-1, idx2, dp), getLength(text1, text2, idx1, idx2-1, dp));
        return dp[idx1][idx2];
    }
}
