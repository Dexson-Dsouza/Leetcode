class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        
        int[][] dp=new int[l1+1][l2+1];
        
        int maxLen=0;
        
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1] = 1 + dp[i][j];
                    maxLen=Math.max(maxLen,dp[i+1][j+1]);
                }
            }
        }
        return maxLen;
    }
}