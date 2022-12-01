class Solution {
    public int calculateTime(String keyboard, String word) {
        int moveCount = 0;
        
        int[] indexes=new int[26];
        for(int i=0;i<keyboard.length();i++){
            indexes[keyboard.charAt(i)-'a']=i;
        }
        
        int curPos=0;
        for(char ch:word.toCharArray()){
            int charIndex = ch-'a';
            moveCount += Math.abs(curPos - indexes[charIndex]);
            curPos = indexes[charIndex];
        }
        return moveCount;
    }
}