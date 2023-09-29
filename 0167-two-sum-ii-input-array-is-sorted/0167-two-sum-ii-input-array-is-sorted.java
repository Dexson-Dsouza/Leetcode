class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> indexMap=new HashMap<>();
        Set<Integer> nums=new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            int n = numbers[i];
            int rem = target-n;
            
            if(nums.contains(rem)){
                return new int[]{indexMap.get(rem)+1,i+1};
            }
            
            nums.add(n);
            indexMap.put(n,i);
        }
        return new int[]{};
    }
}