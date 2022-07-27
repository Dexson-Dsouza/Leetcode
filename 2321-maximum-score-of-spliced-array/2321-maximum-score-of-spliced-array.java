class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(findMax(nums1,nums2),findMax(nums2,nums1));
    }
    
    int findMax(int[] nums1, int[] nums2){
        
        int sum1=0;
        for(int n:nums1){
            sum1+=n;
        }
        
        int sum2=0;
        for(int n:nums2){
            sum2+=n;
        }
        
        
        int maxExtraScore=0;
        int curExtraScore=0;
        
        for(int i=0;i<nums1.length;i++){
            int diff=nums2[i]-nums1[i];
            
            curExtraScore=Math.max(0,Math.max(curExtraScore+diff,diff));
            maxExtraScore=Math.max(maxExtraScore,curExtraScore);
        }
        // System.out.println(maxExtraScore+" "+sum1+" "+sum2);
        return maxExtraScore+sum1;
    }
}