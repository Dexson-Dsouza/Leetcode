class RangeModule {
    TreeMap<Integer,Integer> ranges;
    public RangeModule() {
        ranges=new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer leftClosest = ranges.lowerKey(left);
        if(leftClosest!=null && ranges.get(leftClosest)>=left){
            left = leftClosest;
            right = Math.max(right,ranges.get(leftClosest));
        }
        
        Integer rightClosest = ranges.floorKey(right);
        if(rightClosest!=null){
            right = Math.max(right,ranges.get(rightClosest));
        }
        
        // remove all in between
        
        Integer start = ranges.ceilingKey(left);
        while(start!=null && start<=right){
            ranges.remove(start);
            start = ranges.ceilingKey(start);
        }
        
        ranges.put(left,right);
       // System.out.println("a"  + ranges);
    }
    
    public boolean queryRange(int left, int right) {
        Integer leftClosest = ranges.floorKey(left);
        if(leftClosest!=null && ranges.get(leftClosest)>=right){
            return true;
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer leftClosest = ranges.lowerKey(left);
        if(leftClosest!=null && ranges.get(leftClosest)>right){
            int rightEnd = ranges.get(leftClosest);
            ranges.put(leftClosest,left);
            ranges.put(right,rightEnd);
        }else if(leftClosest!=null && ranges.get(leftClosest)>=left){
            ranges.put(leftClosest,left);
        }
        
        Integer rightClosest = ranges.lowerKey(right);
        if(rightClosest!=null && ranges.get(rightClosest)>right){
            ranges.put(right,ranges.get(rightClosest));
        }
        
        // remove all in between
        
        Integer start = ranges.ceilingKey(left);
        while(start!=null && start<right){
            ranges.remove(start);
            start = ranges.ceilingKey(start);
        }
        
       // System.out.println("r "  + ranges);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */