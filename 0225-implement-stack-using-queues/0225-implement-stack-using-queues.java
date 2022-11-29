class MyStack {
    Queue<Integer> q;
    int top;
    
    public MyStack() {
        q = new LinkedList<>();
        top = -1;
    }
    
    public void push(int x) {
        q.add(x);
        top=x;
    }
    
    public int pop() {
        Queue<Integer> temp=new LinkedList<>();
        
        while(q.size()!=1){
            top = q.peek();
            temp.add(q.poll());
        }
        
        int poppedNum=q.poll();
        // if(temp.size()>0){
        //     top=temp.peek();
        // }
        
        q=temp;
        return poppedNum;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */