class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms=new ArrayList<>();
        findPermutations(nums,0,perms);
        return perms;
    }
    
    void findPermutations(int[] nums, int i, List<List<Integer>> perms){
        if(i==nums.length){
            List<Integer> currentPerm=new ArrayList<>();
            for(int n:nums){
               currentPerm.add(n); 
            }
            perms.add(currentPerm);
            return;
        }
        
        for(int index=i;index<nums.length;index++){
            int t=nums[i];
            nums[i]=nums[index];
            nums[index]=t;
            findPermutations(nums,i+1,perms);
            nums[index]=nums[i];
            nums[i]=t;
        }
    }
}