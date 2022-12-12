class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] requiredStep=new int[n+1];
        requiredStep[1]=1;
        requiredStep[2]=2;
        for(int i=3;i<=n;i++){
            requiredStep[i] = requiredStep[i-1] + requiredStep[i-2];
        }
        return 
        requiredStep[n];
    }
}