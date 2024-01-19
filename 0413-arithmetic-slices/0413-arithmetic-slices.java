class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur=0;
        int total=0;
        
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
        
                total+= cur + 1;
                cur++;
            }else{
                cur = 0;
            }
        }
        return total;
    }
}