class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
        
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->b-a);
        minHeap=new PriorityQueue<>();
    
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
        }else if(maxHeap.size()==minHeap.size()){
            int top=minHeap.peek();
            if(num<=top){
                maxHeap.add(num);
            }else{
                minHeap.poll();
                minHeap.add(num);
                maxHeap.add(top);
            }
        }else{
            int top=maxHeap.peek();
            if(num>top){
                minHeap.add(num);
            }else{
                maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(top);
            }
            
        }
    }
    
    public double findMedian() {
        int size=maxHeap.size() + minHeap.size();
        double median;
        if(size%2==1){
            median=maxHeap.peek();
        }else{
            
            median=(double)(maxHeap.peek() + minHeap.peek())/2;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */