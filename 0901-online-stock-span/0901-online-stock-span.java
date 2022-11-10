class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        
        while(st.size()>0 && st.peek()[0]<=price){
            count+=st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */