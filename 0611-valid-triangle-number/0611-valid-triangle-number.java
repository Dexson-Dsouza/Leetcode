class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                continue;
            }
            int j=i+1;
            int k=i+2;
            while(j<nums.length){
                while(k<nums.length && nums[k] < nums[i]+nums[j]){
                    k++;
                }
                count += (k-j-1);
                j++;
            }
        }
        return count;
    }
}