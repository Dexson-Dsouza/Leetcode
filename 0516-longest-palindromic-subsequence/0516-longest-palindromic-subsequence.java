class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        if(n==1){
            return 1;
        }
        int[][] dp=new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;   
            }else{
                dp[i][i+1]=1;  
            }
        }
        
        for(int len=2;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j=i+len;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
                // System.out.println(i+" "+j+" "+dp[i][j]);
            }
        }
        return dp[0][n-1];
    }
}