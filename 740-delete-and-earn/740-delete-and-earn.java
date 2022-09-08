class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 10000;
        int[] count=new int[maxNum+1];
        
        for(int n:nums){
            count[n]++;
        }
        
        for(int i=2;i<=maxNum;i++){
            count[i] = Math.max(count[i-1], count[i-2] + i* count[i]);
        }
        
        int maxPointEarned=0;
        for(int i=1;i<=maxNum;i++){
            maxPointEarned=Math.max(maxPointEarned, count[i]);
        }
        
        return maxPointEarned;
    }
}