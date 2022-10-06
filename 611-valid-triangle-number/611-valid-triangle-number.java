class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-2;i++){
            if(nums[i]==0){
                continue;
            }
            int j=i+1;
            int k=i+2;
            while(j<n){
                while(k<n && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                count+=(k-j-1);
                j++;
            }
        }
        return count;
    }
}