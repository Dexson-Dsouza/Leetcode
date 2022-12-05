class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int n:nums){
            int index = Math.abs(n)-1;
            if(nums[index]<0){
                res.add(Math.abs(n));
            }else{
                nums[index]*=-1;
            }
            
        }
        return res;
    }
}