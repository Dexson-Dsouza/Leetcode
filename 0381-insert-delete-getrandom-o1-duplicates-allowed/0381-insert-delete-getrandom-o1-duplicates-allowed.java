class RandomizedCollection {
    Map<Integer,Set<Integer>> indexes;
    List<Integer> nums;
    public RandomizedCollection() {
        nums=new ArrayList();
        indexes=new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean isNewNumber=false;
        
        if(indexes.containsKey(val)==false){
            isNewNumber=true;
            indexes.put(val,new HashSet<>());
        }
        
        indexes.get(val).add(nums.size());
        nums.add(val);
        return isNewNumber;
    }
    
    public boolean remove(int val) {
        if(indexes.containsKey(val)==false){
            return false;
        }
        if(nums.get(nums.size()-1)==val){
            indexes.get(val).remove(nums.size()-1);
            nums.remove(nums.size()-1);
        }else{
            int lastVal = nums.get(nums.size()-1);
            int curIndex = indexes.get(val).iterator().next();
            indexes.get(val).remove(curIndex);
            
           
            
            indexes.get(lastVal).remove(nums.size()-1);
            indexes.get(lastVal).add(curIndex);
            nums.set(curIndex,lastVal);
            nums.remove(nums.size()-1);
        }
        
        if(indexes.get(val).size()==0){
            indexes.remove(val);
        }
        // System.out.println(indexes+" "+val);
        // System.out.println(nums);
        return true;
    }
    
    public int getRandom() {
        int randomIndex= (int)(Math.random()*nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */