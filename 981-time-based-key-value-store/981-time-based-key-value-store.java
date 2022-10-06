class TimeMap {
    Map<String,TreeMap<Integer,String>> store;
    public TimeMap() {
     store=new HashMap<>();   
    }
    
    public void set(String key, String value, int timestamp) {
        if(store.containsKey(key)==false){
            store.put(key,new TreeMap<>());
        }
        store.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(store.containsKey(key)==false){
            return "";
        }
        Integer time= store.get(key).floorKey(timestamp);
        if(time==null){
            return "";
        }
        return store.get(key).get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */