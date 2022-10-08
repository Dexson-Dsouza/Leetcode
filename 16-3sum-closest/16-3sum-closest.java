class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest=0;
        int difference=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                
                int currDiff= Math.abs(target-sum);
                if(currDiff<difference){
                    difference=currDiff;
                    closest=sum;
                }
                
                if(sum<=target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return closest;
    }
}