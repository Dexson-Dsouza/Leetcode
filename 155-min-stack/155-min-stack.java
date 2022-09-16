class MinStack {
    
    Stack<Integer> minNums;
    Stack<Integer> nums;
    
    public MinStack() {
        minNums=new Stack<>();
        nums=new Stack<>();
    }
    
    public void push(int val) {
        nums.push(val);
        if(minNums.size()==0 || val<=minNums.peek()){
            minNums.push(val);
        }
    }
    
    public void pop() {
        int val= nums.pop();
        if(val==minNums.peek()){
            minNums.pop();
        }
    }
    
    public int top() {
        return nums.peek();
    }
    
    public int getMin() {
        return minNums.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */