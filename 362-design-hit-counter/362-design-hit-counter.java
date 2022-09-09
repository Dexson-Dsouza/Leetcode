class HitCounter {
    TreeMap<Integer,Integer> hitMap;
    public HitCounter() {
        hitMap=new TreeMap<>();
    }
    
    public void hit(int timestamp) {
        int prevCount=0;
        if(hitMap.floorKey(timestamp)!=null){
            prevCount=hitMap.get(hitMap.floorKey(timestamp));
        }
        hitMap.put(timestamp,prevCount+1);
    }
    
    public int getHits(int timestamp) {
        int prevCount=0;
        if(hitMap.floorKey(timestamp-300)!=null){
            prevCount=hitMap.get(hitMap.floorKey(timestamp-300));
        }
        int currentCount=0;
        if(hitMap.floorKey(timestamp)!=null){
            currentCount=hitMap.get(hitMap.floorKey(timestamp));
        }
        return currentCount-prevCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */