class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion of chars different from s[i].
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) for (int j = 0; j <= k; j++) dp[i][j] = 9999;
		// for (int[] i : dp) Arrays.fill(i, n); // this is a bit slower (100ms)
        dp[0][0] = 0;
        for(int len = 1; len <= n; len++) { // len
            for(int j = 0; j <= Math.min(len ,k); j++) {  // try all possible deletes          
                int cnt = 0, del = 0;
                for(int i = len; i >= 1; i--) { // keep s[i], concat the same, remove the different
                    if(s.charAt(i - 1) == s.charAt(len - 1)) cnt++;
                    else del++;
                    if(j - del >= 0) { // check if deletes are valid
                        dp[len][j] = Math.min(dp[len][j], 
                                            dp[i-1][j-del] + 1 + 
                                            (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                    }
                }
                if (j > 0){ // delete s[i]
                    dp[len][j] = Math.min(dp[len][j], dp[len-1][j-1]);
                }
                // System.out.print(dp[len][j]+" ");
            }
            // System.out.println();
        }
        return dp[n][k];
    }
}

