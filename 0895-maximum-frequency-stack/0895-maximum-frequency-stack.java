class FreqStack {
    Map<Integer,Integer> freqMap=new HashMap<>();
    Map<Integer,Stack<Integer>> freqNums=new HashMap<>();
    int maxCount=0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int count=1;
        if(freqMap.containsKey(val)){
            count=freqMap.get(val)+1;
        }
        freqMap.put(val,count);
        if(freqNums.containsKey(count)==false){
            freqNums.put(count,new Stack<>());
        }
        freqNums.get(count).push(val);
        maxCount=Math.max(maxCount,count);
    }
    
    public int pop() {
        int val = freqNums.get(maxCount).pop();
        freqMap.put(val,maxCount-1);
        if(freqNums.get(maxCount).size()==0){
            freqNums.remove(maxCount);
            maxCount--;
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */