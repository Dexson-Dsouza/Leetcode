class Solution {
    public int maxProduct(int[] nums) {
        int mx=1;
        int mn=1;
        int res=Integer.MIN_VALUE;
        
        for(int n:nums){
            int t = mx;
            mx = Math.max(n,Math.max(t*n,mn*n));
            mn = Math.min(n,Math.min(t*n,mn*n));
            // System.out.println(mn+" "+mx);
            res =Math.max(res,mx);
        }
        return res;
    }
}