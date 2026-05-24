class KthLargest {    
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        for (int num:nums) {
            this.heap.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        this.heap.offer(val);
        
        while (this.heap.size() > this.k) {
            this.heap.poll();
        }

        
        return this.heap.peek();
    }
}
