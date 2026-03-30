class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num:nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        freqMap.forEach((key, v) -> {
            if (bucket[v] == null) bucket[v] = new ArrayList<>();
            bucket[v].add(key);
        });

        List<Integer> result = new ArrayList<>();
        int kCount = k;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            if (bucket[i].size() <= kCount) {
                result.addAll(bucket[i]);
                kCount -= bucket[i].size();
            } else {
                for (int j = 0; j < kCount; j++) {
                    result.add(bucket[i].get(j));
                }
                kCount = 0;
            }

            if (kCount == 0) break;
        }

        int[] resultInt = new int[result.size()];
        for (int i=0;i<result.size();i++) {
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }
}
