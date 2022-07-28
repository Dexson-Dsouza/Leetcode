class Solution {
    public int strangePrinter(String s) {
        int len=s.length();
        
        int[][] dp=new int[len][len];
        
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        
        for(int curLen=2;curLen<=len;curLen++){
            for(int start=0;start+curLen-1<len;start++){
                int end=start+curLen-1;
                dp[start][end]=Integer.MAX_VALUE;
                for(int k=start;k<end;k++){
                    int curTurns= dp[start][k]+dp[k+1][end];
                    if(s.charAt(start)==s.charAt(end)){
                        curTurns--;
                    }
                    dp[start][end]=Math.min(dp[start][end],curTurns);
                }
            }
        }
        return dp[0][len-1];
    }
}