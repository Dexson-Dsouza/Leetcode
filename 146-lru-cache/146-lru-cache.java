class LRUCache {
    static class DLL{
        int key;
        int val;
        DLL next;
        DLL prev;
        DLL(int k, int v){
            key=k;
            val=v;
            prev=next=null;
        }
    }
    
    DLL head;
    DLL tail;
    int size;
    Map<Integer,DLL> keyNodeMap;
    
    public LRUCache(int capacity) {
        size=capacity;
        head=new DLL(0,0);
        tail=new DLL(0,0);
        tail.prev=head;
        head.next=tail;
        keyNodeMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(keyNodeMap.containsKey(key)==false){
            return -1;
        }
        DLL node=keyNodeMap.get(key);
        int val= node.val;
        update(node);
        return val;
    }
    
    void update(DLL node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }
    
    void evict(){
        DLL LruNode=tail.prev;
        keyNodeMap.remove(LruNode.key);
        DLL prevNode = LruNode.prev;
        prevNode.next=tail;
        tail.prev=prevNode;
        
    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)==true){
            DLL node=keyNodeMap.get(key);
            node.val=value;
            update(node);
        }else{
            DLL newNode=new DLL(key,value);
            head.next.prev=newNode;
            newNode.next=head.next;
            head.next=newNode;
            newNode.prev=head;
            keyNodeMap.put(key,newNode);
            if(size==0){
                evict();
            }else{
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */