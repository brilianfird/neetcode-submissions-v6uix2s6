class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        Arrays.fill(dp, -1);
        int result = getCoin(coins, amount, 0, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int getCoin(int[] coins, int amount, int idx, int[] dp) {
        if (amount == 0) return 0;
        else if (dp[amount] != -1) return dp[amount];
        int minCoin = Integer.MAX_VALUE;
        for (int i=idx;i<coins.length;i++) {
            if (coins[i] > amount) break;
                minCoin = Math.min(minCoin, getCoin(coins, amount - coins[i], i, dp));
        }
        dp[amount] = minCoin == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCoin+1;;
        return dp[amount];
    }
}
