public class Dll{
    Dll next;
    Dll prev;
    int val;
    int key;
    Dll(int key, int val){
        this.val = val;
        this.key = key;
        next=null;
        prev=null;
    }
}

class LRUCache {
    Dll head;
    Dll tail;
    int capacity;
    Map<Integer,Dll> valueMap;
    public LRUCache(int capacity) {
        head=new Dll(0,0);
        tail=new Dll(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        valueMap = new HashMap<>();
    }
    
    public void addToList(Dll n){
        head.next.prev=n;
        n.next=head.next;
        n.prev=head;
        head.next=n;
    }
    
    public void deleteNode(Dll n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)==false){
            return -1;
        }
        Dll n = valueMap.get(key);
        deleteNode(n);
        addToList(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(valueMap.containsKey(key)==true){
            Dll n = valueMap.get(key);
            n.val = value;
            deleteNode(n);
            addToList(n);
        }else{
            if(capacity>0){
                capacity--;
            }else{
                remove(tail.prev);
            }
            addNewNode(key,value);
        }
    }
    
    public void remove(Dll n){
        valueMap.remove(n.key);
        deleteNode(n);
    }
    
    public void addNewNode(int key, int value){
        Dll valueNode = new Dll(key,value);
        addToList(valueNode);   
        valueMap.put(key,valueNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */