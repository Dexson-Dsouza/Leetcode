class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] ways=new int[target+1];
        ways[0]=1;
        for(int i=1;i<=target;i++){
            for(int n:nums){
                if(i>=n){
                    ways[i]+=ways[i-n];
                }
            }
        }
        return ways[target];
    }
}