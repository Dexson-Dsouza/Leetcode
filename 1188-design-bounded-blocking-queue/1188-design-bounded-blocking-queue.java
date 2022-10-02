class BoundedBlockingQueue {
    Semaphore  push;
    Semaphore  pop;
    ConcurrentLinkedDeque<Integer> nums;
    public BoundedBlockingQueue(int capacity) {
        nums=new ConcurrentLinkedDeque<>();
        push=new Semaphore(capacity);
        pop=new Semaphore(0);
    }
    
    public void enqueue(int element) throws InterruptedException {
        push.acquire();
        nums.add(element);
        pop.release();
    }
    
    public int dequeue() throws InterruptedException {
        pop.acquire();
        int val = nums.poll();
        push.release();
        return val;
    }
    
    public int size() {
        return nums.size();
    }
}