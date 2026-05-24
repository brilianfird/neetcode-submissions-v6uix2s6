class KthLargest {    
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int num:nums) {
            this.heap.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        this.heap.offer(val);
        PriorityQueue<Integer> copy = new PriorityQueue<>(heap);

        int lastInt = 0;

        for (int i = 0;i<k;i++) {
            if (copy.isEmpty()) break;
            lastInt = copy.poll();
        }
        return lastInt;
    }
}
