class Solution {
    public int missingElement(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            int missingNumCount=nums[i]-nums[i-1]-1;
            if(missingNumCount<k){
                k-=missingNumCount;
            }else{
                return nums[i-1]+k;
            }
        }
        return nums[nums.length-1]+k;
    }
}