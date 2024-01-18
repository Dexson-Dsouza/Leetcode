class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        
        for(int i=1;i<nums.length;i++){
            int diff = nums[i] - nums[i-1];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[j-1]==diff){
                    count++;
                }else{
                    break;
                }
            }
        }
        
        return count;
    }
}