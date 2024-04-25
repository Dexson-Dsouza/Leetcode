class Solution {
    public int longestIdealString(String s, int k) {
        int[] prevMaxLen=new int[26];
        
        int maxLen=0;
        for(char ch:s.toCharArray()){
            int curLen = 1;
            int charIndex = ch-'a';
            
            int leftBound = Math.max(0,charIndex-k);
            int rightBound = Math.min(25,charIndex+k);
            for(int validCharacter =leftBound; validCharacter<=rightBound;validCharacter++){
                curLen = Math.max(curLen,1 + prevMaxLen[validCharacter]);
            }
            prevMaxLen[charIndex]=curLen;
            maxLen=Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}