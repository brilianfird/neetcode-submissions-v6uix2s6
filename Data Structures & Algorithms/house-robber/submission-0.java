class Solution {
    public int rob(int[] nums) {
        return getRob(nums, 0, new int[nums.length]);
    }

    public int getRob(int[] nums, int currHouse, int[] dp) {
        if (currHouse >= nums.length) return 0;
        else if (dp[currHouse] != 0) return dp[currHouse];
        dp[currHouse] = Math.max(getRob(nums, currHouse+1, dp), getRob(nums, currHouse+2, dp) + nums[currHouse]);
        return dp[currHouse];
    }
}
