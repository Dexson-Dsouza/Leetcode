class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int countTriplets=0;
        int numsLength=nums.length;
        for(int i=0;i<numsLength-1;i++){
            if(nums[i]==0){
                continue;
            }
            int k=i+2;
            for(int j=i+1;j<numsLength;j++){
                
                while(k<numsLength && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                countTriplets+= (k-1-j);
            }
            
        }
        return countTriplets;
    }
}