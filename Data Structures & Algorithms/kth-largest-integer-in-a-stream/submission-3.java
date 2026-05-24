class KthLargest {    
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int num:nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        this.heap.offer(val);
        
        while (this.heap.size() > this.k) {
            this.heap.poll();
        }

        
        return this.heap.peek();
    }
}
