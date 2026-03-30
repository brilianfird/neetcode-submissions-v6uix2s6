class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numToIdxMap = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            numToIdxMap.put(nums[i], i);
        }

        int maxLength = 0;

        for(int i=nums.length-1;i>=0;i--) {
            int currLength = 1;
            int nextNum = nums[i]-1;
            boolean nextNumExist = numToIdxMap.containsKey(nextNum);
            while (nextNumExist) {
                currLength++;
                nextNum = nextNum - 1;
                nextNumExist = numToIdxMap.containsKey(nextNum);
            }
            maxLength = Math.max(currLength, maxLength);

        }

        return maxLength;
    }
}
