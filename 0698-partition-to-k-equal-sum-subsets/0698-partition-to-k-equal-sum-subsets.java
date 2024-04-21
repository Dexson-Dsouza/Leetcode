class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%k!=0){
            return false; 
        }
        boolean[] used=new boolean[nums.length];
        return canMake(nums,0,k,0,sum/k,used);
    }
    
    public boolean canMake(int[] arr, int i, int k, int cs, int ts, boolean[] used){
        if(i==arr.length){
            return false;    
        }
        
        if(k==1){
            return true;
        }
        
        if(cs==ts){
            return canMake(arr,0,k-1,0,ts,used);
        }else{
            boolean res=false;
            if(!used[i] && cs+arr[i]<=ts){
                used[i]=true;
                res|= canMake(arr,i+1,k,cs+arr[i],ts,used);
                used[i]=false;
            }
            res|= canMake(arr,i+1,k,cs,ts,used);
            return res;
        }
    }
}