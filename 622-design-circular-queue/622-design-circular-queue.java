class MyCircularQueue {
    static class Node{
        Node next;
        Node prev;
        int val;
        Node(int v){
            next=null;
            prev=null;
            val=v;
        }
        
        Node(){
            next=null;
            prev=null;
        }
    }
    
    int size;
    int curSize;
    Node head,tail;
    public MyCircularQueue(int k) {
        size=k;
        curSize=0;
        head=new Node();
        tail=new Node();
        head.next=tail;
        head.prev=tail;
        tail.next=head;
        tail.prev=head;
    }
    
    public boolean enQueue(int value) {
        if(size==curSize){
            return false;
        }
        Node n=new Node(value);
        curSize++;
        Node LastNode=tail.prev;
        LastNode.next=n;
        n.prev=LastNode;
        n.next=tail;
        tail.prev=n;
        return true;
    }
    
    public boolean deQueue() {
        if(curSize==0){
            return false;
        }
        curSize--;
        Node secondNode=head.next.next;
        secondNode.prev=head;
        head.next=secondNode;
        return true;
    }
    
    public int Front() {
        if(curSize==0){
            return -1;
        }
        return head.next.val;
    }
    
    public int Rear() {
        if(curSize==0){
            return -1;
        }
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return curSize==0;
    }
    
    public boolean isFull() {
        return curSize==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */