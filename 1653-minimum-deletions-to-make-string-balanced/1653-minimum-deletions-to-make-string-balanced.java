class Solution {
    public int minimumDeletions(String s) {
        int countB=0;
        for(char ch:s.toCharArray()){
            if(ch=='b'){
                countB++;
            }
        }
        int maxLen=0;
        int countA=0;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                countA++;
            }
            maxLen=Math.max(maxLen,countA+countB);
            if(ch=='b'){
                countB--;
            }
        }
        return s.length()-maxLen;
    }
}