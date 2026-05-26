class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermute(nums, new boolean[nums.length], new ArrayDeque<>(), result);

        return result;
    }

    public void getPermute(int[] nums, boolean[] visited, Deque<Integer> currResult, List<List<Integer>> result) {
        if (currResult.size() == nums.length) {
            result.add(new ArrayList<>(currResult));
            return;
        }

        for (int i=0;i<visited.length;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            currResult.offer(nums[i]);
            getPermute(nums, visited, currResult, result);
            visited[i] = false;
            currResult.pollLast();
        }
    }
}
