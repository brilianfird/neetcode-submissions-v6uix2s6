class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return getMinCost(cost.length, cost, new HashMap<>());
    }

    public int getMinCost(int n, int[] cost, Map<Integer, Integer> dp) {
        if (n < 0) return 0;
        else if (dp.containsKey(n)) return dp.get(n);
        dp.put(n, Math.min(getMinCost(n-1, cost, dp), getMinCost(n-2, cost, dp)) + (n == cost.length ? 0 : cost[n]));
        return dp.get(n);
    }
}
