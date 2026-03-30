class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums = [1,2,4,6]
        // first pass = [1, 1, 2, 8]
        // second pass =[48, 24, 6, 8]

        int[] result = new int[nums.length];

        for (int i=0;i<nums.length;i++) {
            result[i] = 1;
            if (i > 0) {
                result[i] = nums[i-1] * result[i-1];
            }
        }

        int suffix = 1;

        for (int i=nums.length-1;i>=0;i--) {
            if (i < nums.length - 1) suffix *= nums[i+1];
            result[i] *= suffix;
        }

        return result;
    }
}  
