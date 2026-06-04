class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -1000;
        int currSum = -1000;

        for (int i=0;i<nums.length;i++) {
            currSum += nums[i];
            if (nums[i] > currSum) {
                currSum = nums[i];
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}