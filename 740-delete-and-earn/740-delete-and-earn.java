class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 10000;
        int[] count=new int[maxNum+1];
        
        for(int n:nums){
            count[n]++;
        }
        
        int[] maxPoints=new int[maxNum+1];
        maxPoints[1]=count[1];
        for(int i=2;i<=maxNum;i++){
            maxPoints[i] = Math.max(maxPoints[i-1], maxPoints[i-2] + i* count[i]);
        }
        
        int maxPointEarned=0;
        for(int i=1;i<=maxNum;i++){
            maxPointEarned=Math.max(maxPointEarned, maxPoints[i]);
        }
        
        return maxPointEarned;
    }
}