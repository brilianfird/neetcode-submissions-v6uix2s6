class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinationSum(nums, 0, target, result, new ArrayDeque<>());
        return result;
    }

    public void getCombinationSum(int[] nums, int idx, int target, List<List<Integer>> result, Deque<Integer> currResult) {
        if (target == 0) {
            result.add(new ArrayList<>(currResult));
            return;
        } else if (idx > nums.length) {
            return;
        }

        for (int i=idx;i<nums.length;i++) {
            if (nums[i] <= target) {
                currResult.offerLast(nums[i]);
                getCombinationSum(nums, i, target - nums[i], result, currResult);
                currResult.pollLast();
            }
        }

    }
}
