class RangeModule {
    TreeMap<Integer,Integer> ranges;
    
    public RangeModule() {
            ranges=new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer start=ranges.floorKey(left);
        if(start!=null && start<left && ranges.get(start)>=left){
            left=start;
        }
        
        Integer end=ranges.floorKey(right);
        
        if(end!=null && end<=right && ranges.get(end)>=right){
            right=ranges.get(end);
        }
        
        Map<Integer,Integer> subMap=ranges.subMap(left,true,right,false);
        
        for(int key:new ArrayList<>(subMap.keySet())){
            ranges.remove(key);
        }
        ranges.put(left,right);
        // System.out.println(ranges);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start=ranges.floorKey(left);
        return start!=null && ranges.get(start)>=right;
    }
    
    public void removeRange(int left, int right) {
        
        
        Integer end=ranges.floorKey(right);
        
        if(end!=null && end<right && ranges.get(end)>right){
            ranges.put(right,ranges.get(end));
        }
        
        Integer start=ranges.floorKey(left);
        if(start!=null && start<left && ranges.get(start)>=left){
            ranges.put(start,left);
        }
        
        Map<Integer,Integer> subMap=ranges.subMap(left,true,right,false);
        
        for(int key:new ArrayList<>(subMap.keySet())){
            ranges.remove(key);
        }
        // System.out.println("D " + ranges);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */