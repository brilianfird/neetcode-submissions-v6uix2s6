class MinStack {

    private int[] minStack;
    private int[] stack;
    private int currIdx;

    public MinStack() {
        this.minStack = new int[10000];
        this.stack = new int[10000];
        this.currIdx = 0;
    }
    
    public void push(int val) {
        this.stack[this.currIdx] = val;
        if (currIdx != 0 && this.minStack[currIdx-1] < val) {
            this.minStack[currIdx] = this.minStack[currIdx-1];
        } else {
            this.minStack[currIdx] = val;
        }
        this.currIdx++;
    }
    
    public void pop() {
        this.currIdx--;
    }
    
    public int top() {
        return this.stack[this.currIdx-1];
    }
    
    public int getMin() {   
        return this.minStack[this.currIdx-1];
    }
}
