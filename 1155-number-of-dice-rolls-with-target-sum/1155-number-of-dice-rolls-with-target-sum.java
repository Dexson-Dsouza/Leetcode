class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod=(int)(Math.pow(10,9)+7);
        
        int[] sum=new int[target+1];
        sum[0]=1;
        
        for(int dice=1;dice<=n;dice++){
            int[] nextSum=new int[target+1];
            for(int curSum=0;curSum<=target;curSum++){
                for(int i=1;i<=k;i++){
                    int nextNum=curSum+i;
                    if(sum[curSum]!=0 && nextNum<=target){
                        nextSum[nextNum]= (nextSum[nextNum]+sum[curSum])%mod;
                    }   
                }
            }
            sum=nextSum;
        }
        return sum[target];   
    }
}