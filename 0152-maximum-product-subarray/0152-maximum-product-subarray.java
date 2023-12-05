class Solution {
    public int maxProduct(int[] nums) {
        int max=1;
        int min=1;
        int res=Integer.MIN_VALUE;
        for(int n:nums){
            if(n==0){
                res=Math.max(0,res);
                max=1;
                min=1;
                
            }else{
                if(n<0){
                    int temp=min;
                    min=max;
                    max=temp;
                }
                
                max = max*n;
                max=Math.max(max,n);
                min=min*n;
                min=Math.min(min,n);
                res=Math.max(max,res);
            }
        }
        return res;
    }
}