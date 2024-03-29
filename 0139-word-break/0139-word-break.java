class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word: wordDict) {
                // Handle out of bounds case
                if (i < word.length()) {
                    continue;
                }
                
                if (dp[i - word.length()] 
                    && s.substring(i - word.length(), i ).equals(word) ){
                    dp[i] = true;   
                    break;
                 }
            }
        }
        
        return dp[s.length()];
    }
}