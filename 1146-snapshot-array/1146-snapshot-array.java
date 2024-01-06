class SnapshotArray {
    Map<Integer,TreeMap<Integer,Integer>> indexSnapMap;
    int s_id;
    
    public SnapshotArray(int length) {
        indexSnapMap=new HashMap<>();
        s_id=0;
    }
    
    public void set(int index, int val) {
        if(!indexSnapMap.containsKey(index)){
            indexSnapMap.put(index,new TreeMap<>());
        }
        TreeMap<Integer,Integer> snapValMap = indexSnapMap.get(index);
        snapValMap.put(s_id,val);
    }
    
    public int snap() {
        s_id++;
        return s_id-1;
    }
    
    public int get(int index, int snap_id) {
        int val = 0;
        if(indexSnapMap.containsKey(index)){
            TreeMap<Integer,Integer> snapValMap = indexSnapMap.get(index);
            Integer closestSnapId = snapValMap.floorKey(snap_id);
            if(closestSnapId!=null){
                val = snapValMap.get(closestSnapId);
            }
        }
        return val;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */