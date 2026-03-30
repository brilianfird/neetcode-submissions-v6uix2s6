class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int end = 0; end < n; end++) {
            // 1. Remove indices that are out of this window
            while (!deque.isEmpty() && deque.peekFirst() < end - k + 1) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order in deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[end]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(end);

            // 4. Record answer once the first window is complete
            if (end >= k - 1) {
                result[end - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}