class Solution {
    public int trap(int[] height) {
        /**
        left = 0
        right = height - 1
        maxLeft = 0
        maxRight = 0
        trappedWater = 0
        loop (left <= right)
            if height[left] < height[right]:
                maxLeft = max(maxLeft, height[left])
                trappedWater += maxLeft - height[left]
                left++;
            else:
                maxRight = max(maxRight, height[right])
                trappedWater += maxRight - height[right]
                right--;

        return trappedWater;
        **/

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                trappedWater += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                trappedWater += maxRight - height[right];
                right--;
            }
        }
        return trappedWater;
    }
}
