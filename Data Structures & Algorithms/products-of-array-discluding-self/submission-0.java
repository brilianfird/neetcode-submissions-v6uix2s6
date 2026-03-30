class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 2, 8, 48]
        // [48, 48, 24, 6]
        // result = [48, 24, 12, 8]
        int[] product = new int[nums.length];
        int[] reverseProduct = new int[nums.length];

        for (int i=0;i<nums.length;i++) {
            int revIdx = nums.length - 1 - i;
            product[i] = nums[i];
            reverseProduct[revIdx] = nums[revIdx];
            if (i != 0) {
                product[i] *= product[i-1];
                reverseProduct[revIdx] *= reverseProduct[revIdx+1];
            }
        }

        int[] result = new int[nums.length];

        for (int i=0;i<product.length;i++) {
            result[i] = 1;
            if (i > 0) result[i] *= product[i-1];
            if (i < product.length-1) result[i] *= reverseProduct[i+1];
        }

        return result;
    }
}  
