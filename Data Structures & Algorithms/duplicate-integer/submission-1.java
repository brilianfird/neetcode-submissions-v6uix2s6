class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> duplicateMap = new HashMap<>();
        for (int num: nums) {
            if (duplicateMap.get(num) != null) return true;
            duplicateMap.put(num, true);
        }
        return false;
    }
}