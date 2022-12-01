public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            if(dp[i-1]==false){
                continue;
            }
            for(String word:wordDictSet){
                int len = word.length();
                int startIndex = i-1;
                int endIndex = startIndex+len;
                if(endIndex<=s.length() && s.substring(startIndex,endIndex).equals(word)){
                    dp[endIndex]=true;
                }
            }
        }
        return dp[s.length()];
    }
}