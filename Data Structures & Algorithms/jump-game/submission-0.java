class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return isCanJump(nums, 0, dp);
    }

    public boolean isCanJump(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length - 1) {
            return true;
        } else if (dp[idx] != -1) {
            return dp[idx] == 0 ? false : true;
        }

        for (int i=idx+1;i <= idx + nums[idx];i++) {
            if (isCanJump(nums, i, dp)) {
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }
}
