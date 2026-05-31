class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxVal = nums[0];

        for (int i=1;i<nums.length;i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = currMin;
                currMin = currMax * num;
                currMax = temp * num;
            } else {
                currMin *= num;
                currMax *= num;
            }

            currMin = Math.min(currMin, num);
            currMax = Math.max(currMax, num);
            maxVal = Math.max(maxVal, currMax);
        }

        return maxVal;
    }
}
