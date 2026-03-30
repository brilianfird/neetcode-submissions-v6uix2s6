class Solution {
    public int maxArea(int[] heights) {
        /**
        left = 0
        right = heights.length - 1
        loop (left < right)
            area = min(height[left], height[right]) * (right-left)
            maxArea = max(area, maxArea)
            if height[left] < height[right]: left++;
            else right--;
        return maxArea;
        **/
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right-left);
            maxArea = Math.max(area, maxArea);
            if (heights[left] < heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
