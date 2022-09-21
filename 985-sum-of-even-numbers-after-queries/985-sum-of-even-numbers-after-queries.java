class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int currentSum=0;
        for(int n:nums){
            if(n%2==0){
                currentSum+=n;
            }
        }
        
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] q=queries[i];
            
            int index=q[1];
            int val=q[0];
            
            if(nums[index]%2==0){
                currentSum-=nums[index];
            }
            
            nums[index]+= val;
            
            if(nums[index]%2==0){
                currentSum+=nums[index];
            }
            result[i]=currentSum;
        }
        return result;
    }
}