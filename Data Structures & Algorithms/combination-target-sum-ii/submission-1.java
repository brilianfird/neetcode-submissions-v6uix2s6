class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> result = new ArrayList<>();
      doSum(candidates, target, 0, new ArrayDeque<>(), result);
      return result;
    }

    private void doSum(int[] candidates, int target, int start, Deque<Integer> currResult, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currResult));
            return;
        } else if (start >= candidates.length) {
            return;
        }


        for (int i=start;i<candidates.length;i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;
            currResult.offer(candidates[i]);
            doSum(candidates, target - candidates[i], i+1, currResult, result);
            currResult.pollLast();
        }

    }
}
