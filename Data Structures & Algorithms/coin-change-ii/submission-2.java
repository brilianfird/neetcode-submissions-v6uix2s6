class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i=0;i<coins.length;i++) {
            Arrays.fill(dp[i], -1);
        }

        return getChange(amount, coins, 0, dp);
    }

    public int getChange(int amount, int[] coins, int currIdx, int[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || currIdx >= coins.length) return 0;
        else if (dp[currIdx][amount] != -1) return dp[currIdx][amount];

        dp[currIdx][amount] = getChange(amount - coins[currIdx], coins, currIdx, dp) + getChange(amount, coins, currIdx+1, dp);
        return dp[currIdx][amount];
    }
}
