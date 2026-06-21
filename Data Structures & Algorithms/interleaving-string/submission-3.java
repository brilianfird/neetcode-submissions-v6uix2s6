class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return canInterleave(s1, s2, s3, 0, 0, dp);
    }

    public boolean canInterleave(String s1, String s2, String s3, int idx1, int idx2, Boolean[][] dp) {
        if (idx1+idx2 == s3.length()) {
            return true;
        } else if (dp[idx1][idx2] != null) {
            return dp[idx1][idx2];
        }

        dp[idx1][idx2] = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx1+idx2)) {
            dp[idx1][idx2] = dp[idx1][idx2] || canInterleave(s1, s2, s3, idx1+1, idx2, dp);
        }

        if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx1+idx2)) {
            dp[idx1][idx2] = dp[idx1][idx2] || canInterleave(s1, s2, s3, idx1, idx2+1, dp);
        }

        return dp[idx1][idx2];

    }
}
