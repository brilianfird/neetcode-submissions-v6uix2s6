class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int left = i+1;
            int right = nums.length-1;

            while (left<right) {
                while (left < right && left > i + 1 && nums[left] == nums[left-1]) {
                    left++;
                    continue;
                }
                if (left >= right) break;
                int sumAll = nums[left]+nums[right];
                
                if (sumAll < target) left++; 
                else if (sumAll > target) right--;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }
            }
        }

        return result;
    }
}
