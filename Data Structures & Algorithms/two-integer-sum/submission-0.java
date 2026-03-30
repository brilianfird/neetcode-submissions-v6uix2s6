class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0;i<nums.length;i++) {
            int t = target - nums[i];
            if (numToIndexMap.get(t) != null) {
                return new int[]{numToIndexMap.get(t), i};
            }
            numToIndexMap.put(nums[i], i);
        }

        return new int[]{1,1};
    }
}
