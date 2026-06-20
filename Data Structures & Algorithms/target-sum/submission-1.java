class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i=0;i<nums.length;i++) {
            dp[i] = new HashMap<>();
        }
        return getTargetSumCount(nums, 0, target, dp);
    }

    public int getTargetSumCount(int[] nums, int idx, int target, Map<Integer, Integer>[] dp) {
        if (target == 0 && idx == nums.length) {
            return 1;
        } else if (idx == nums.length) {
            return 0;
        } else if (dp[idx].containsKey(target)) {
            return dp[idx].get(target);
        }

        int count = 0;

        count += getTargetSumCount(nums, idx+1, target - nums[idx], dp);
        count += getTargetSumCount(nums, idx+1, target + nums[idx], dp);
        
        dp[idx].put(target, count);

        return count;
    }
}
