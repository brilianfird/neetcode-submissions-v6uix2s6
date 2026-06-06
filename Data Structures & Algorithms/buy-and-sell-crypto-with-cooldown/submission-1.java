class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return getMaxProfit(prices, 0, false, dp);
    }
    
    /**
    1. Buy
    2. Sell
    3. Hold
    **/
    private int getMaxProfit(int[] prices, int day, 
    boolean holding, int[][] dp) {
        int hd = holding ? 1:0;
        if (day >= prices.length) return 0;
        else if (dp[day][hd] != -1) return dp[day][hd];

        // in position
        if (holding) {
            // sell
            dp[day][hd] = Math.max(getMaxProfit(prices, day+2, false, dp) + prices[day], dp[day][hd]);
        } else {
            //buy
            dp[day][hd] = Math.max(dp[day][hd], getMaxProfit(prices, day+1, true, dp) - prices[day]);
        }
        // hodl
        dp[day][hd] = Math.max(dp[day][hd], getMaxProfit(prices, day+1, holding, dp));
        return dp[day][hd];
    }
}
