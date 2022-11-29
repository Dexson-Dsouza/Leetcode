class RandomizedSet {
    List<Integer> arr;
    Map<Integer,Integer> index;
    public RandomizedSet() {
        arr=new ArrayList<>();
        index=new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(index.containsKey(val)){
            return false;
        }
        arr.add(val);
        index.put(val,arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(index.containsKey(val)){
            //swap arr and map
            int curIndex=index.get(val);
            int t=arr.get(curIndex);
            arr.set(curIndex,arr.get(arr.size()-1));
            
            index.put(arr.get(curIndex),curIndex);
            index.remove(val);
            arr.remove(arr.size()-1);
            
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randomIndex=(int)(Math.random()*arr.size());
        return arr.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */