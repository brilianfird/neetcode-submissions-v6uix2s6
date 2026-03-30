class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
        create Max Heap with (num, idx)
        endWindow move = add to max heap
        startWindow move = check if current heap idx < startWindow, if yes then pop until index is >= startWindow
        **/

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        int start = 0;
        int[] result = new int[nums.length - k + 1];

        for (int end=0;end<nums.length;end++) {
            maxHeap.add(new int[]{nums[end], end});

            if (end-start+1 < k) {
                continue;
            }

            if (end-start == k) {
                start++;
                while (maxHeap.peek()[1] < start) {
                    int[] pop = maxHeap.poll();
                }
            }
            result[end-k+1] = maxHeap.peek()[0];
        }

        return result;
    }
}
