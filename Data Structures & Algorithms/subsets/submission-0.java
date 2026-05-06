class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums) {
            int resultSize = result.size();
            for (int i=0;i<resultSize;i++) {
                List<Integer> localRes = new ArrayList<>(result.get(i));
                localRes.add(num);
                result.add(localRes);
            }
        }

        return result;
    }
}
