class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count_3=0;
        int total=0;
        
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                count_3++;
                total+=count_3;
                
            }else{
                count_3 = 0;
            }
        }
        return total;
    }
}