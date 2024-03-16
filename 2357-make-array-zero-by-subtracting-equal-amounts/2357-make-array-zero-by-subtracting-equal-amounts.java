class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniques=new HashSet<>();
        for(int n:nums){
            if(n!=0)    
                uniques.add(n);
        }
        return uniques.size();
    }
}