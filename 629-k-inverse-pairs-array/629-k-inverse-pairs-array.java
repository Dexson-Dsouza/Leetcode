class Solution {
    // n,k = n-1,k-0 + n-1,k-1 +n-1,k-2 .... + n-1, k-n+1
    // n,k+1 = n-1,k+1  + n-1,k+0   +n-1,k-1  ....+ n-1, k-n+1 + n-1, k-n
    // n,k+1 = n,k  + n-1,k+1 -  n-1,k-n
    public int kInversePairs(int n, int k) {
        if(k==0 || k==(n*(n-1))/2){
            return 1;
        }
        if(k>(n*(n-1))/2 ){
            return 0;
        }
        
        int[][] inversePairs=new int [n+1][k+1];
        int mod =(int)(Math.pow(10,9)+7);
    
        for(int num=1;num<=n;num++){
            inversePairs[num][0]=1;
            for(int pair=1;pair<=Math.min(k,(num*(num-1))/2);pair++){  
                inversePairs[num][pair] = (inversePairs[num-1][pair] + inversePairs[num][pair-1])%mod;
                if(pair-num>=0){
                    inversePairs[num][pair] = (inversePairs[num][pair] - inversePairs[num-1][pair-num]+mod)%mod;
                }
            }
        }
        return inversePairs[n][k];
    }
}