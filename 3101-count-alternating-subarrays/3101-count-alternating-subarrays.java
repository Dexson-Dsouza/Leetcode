class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long[] dp=new long[nums.length];
        long res=0;
        
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            if(i>0 && nums[i-1]!=nums[i]){
                dp[i]+=dp[i-1];
            }
            res+=dp[i];
        }
        return res;
    }
}