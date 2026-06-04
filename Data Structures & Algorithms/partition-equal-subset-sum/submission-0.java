class Solution {
    public boolean canPartition(int[] nums) {
        int numSum = Arrays.stream(nums).sum();
        if (numSum % 2 == 1) {
            return false;
        }

        int target = numSum / 2;
        int[] dp = new int[numSum+1];

        Arrays.fill(dp, -1);

        return canDivide(nums, 0, target, dp);
    }

    public boolean canDivide(int[] nums, int currIdx, int target, int[] dp) {
        if (target == 0) {
            return true;
        } else if(currIdx > nums.length) {
            return false;
        } else if (dp[target] != -1) {
            return false;
        }

        for (int i=currIdx;i<nums.length;i++) {
            if (nums[i] <= target && canDivide(nums, i + 1, target - nums[i], dp)) {
                return true;
            }
        }

        dp[target] = 0;
        return false;
    }
}
