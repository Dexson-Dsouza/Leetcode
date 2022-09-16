class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[] maxScore=new int[nums.length+1];
        
        for(int i=multipliers.length-1;i>=0;i--){
            int[] prevScore=maxScore.clone();
            
            for(int left=i;left>=0;left--){
                maxScore[left] = Math.max(nums[left]*multipliers[i] + prevScore[left+1],
                                      nums[nums.length-1-(i-left)]*multipliers[i] + prevScore[left]);
            }
        }
        
        
        return maxScore[0];
    }
    
}