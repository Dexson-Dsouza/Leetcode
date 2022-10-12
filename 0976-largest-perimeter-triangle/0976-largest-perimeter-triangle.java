class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        
        for(int i=len-1;i>=2;i--){
            for(int j=i-1;j>=1;j--){
                if(nums[j]+nums[j-1]>nums[i]){
                    return nums[j]+nums[j-1]+nums[i];
                }
            }
        }
        return 0;
    }
}