class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMinJump(nums, 0, dp);
    }

    public int getMinJump(int[] nums, int currIdx, int[] dp) {
        if (currIdx >= nums.length - 1) return 0;
        else if (dp[currIdx] != -1) return dp[currIdx];
        
        dp[currIdx] = 1000;
        for (int i=currIdx+1;i<=currIdx+nums[currIdx];i++) {
            dp[currIdx] = Math.min(dp[currIdx], getMinJump(nums, i, dp) + 1);
        }

        return dp[currIdx];
    }
}
