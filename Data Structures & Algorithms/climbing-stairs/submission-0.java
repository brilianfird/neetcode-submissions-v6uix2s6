class Solution {
    public int climbStairs(int n) {
        return getCount(n-1, new HashMap<>());
    }

    public int getCount(int n, Map<Integer, Integer> dp) {
        if (n <= 0) return 1;
        else if (dp.containsKey(n)) return dp.get(n);
        dp.put(n, (getCount(n-1, dp) + getCount(n-2, dp)));
        return dp.get(n);
    }
}
