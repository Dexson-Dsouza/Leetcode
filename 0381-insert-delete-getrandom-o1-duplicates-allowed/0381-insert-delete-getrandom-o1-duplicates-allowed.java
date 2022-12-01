class RandomizedCollection {
    Map<Integer,Set<Integer>> elementIndexes;
    List<Integer> nums;
    public RandomizedCollection() {
        nums = new ArrayList<>();
        elementIndexes = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean exists=false;
        if(elementIndexes.containsKey(val)==false){
            exists=true;
            elementIndexes.put(val,new HashSet<>());
        }
        elementIndexes.get(val).add(nums.size());
        nums.add(val);
        return exists;
    }
    
    public boolean remove(int val) {
        if(elementIndexes.containsKey(val)==false){
            return false;
        }
        int index = elementIndexes.get(val).iterator().next();
        elementIndexes.get(val).remove(index);
        if(elementIndexes.get(val).size()==0){
            elementIndexes.remove(val);
        }
        
        int lastIndex = nums.size()-1;
        if(index!=lastIndex){
            int lastNum = nums.get(lastIndex);
            elementIndexes.get(lastNum).remove(lastIndex);
            elementIndexes.get(lastNum).add(index);
            
            nums.set(index,lastNum);
        }
        
        nums.remove(nums.size()-1);
        return true;
    }
    
    public int getRandom() {
        int index = (int)(Math.random()*nums.size());
        return nums.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */