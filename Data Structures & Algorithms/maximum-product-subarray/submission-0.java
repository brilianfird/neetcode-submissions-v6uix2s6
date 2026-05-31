class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1;
        int currMin = 1;
        int maxVal = Integer.MIN_VALUE;

        for (int num:nums) {
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
