class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(coins);
        return getChange(amount, coins, 0, dp);
    }

    public int getChange(int amount, int[] coins, int startIdx, int[][] dp) {
        if (amount == 0) return 1;
        else if (dp[startIdx][amount] != -1) return dp[startIdx][amount];
        dp[startIdx][amount] = 0;
        for (int i=startIdx;i<coins.length;i++) {
            if (coins[i] > amount) break;
            dp[startIdx][amount] += getChange(amount - coins[i] , coins, i, dp);
        }

        return dp[startIdx][amount];
    }
}
