class Solution {
    public int maxProduct(int[] nums) {
        int min=100;
        int max=-100;
        
        int res = -100;
        for(int n:nums){
            if(n>=0){
                max = Math.max(n,max*n);
                min = Math.min(n,min*n);
            }else{
                int t=max;
                max = Math.max(n,min*n);
                min = Math.min(n,t*n);
            }
            res=Math.max(res,max);
        }
        return res;
    }
}