class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left=0;
        int right=tokens.length-1;
        int maxScore=0;
        int curPower=power;
        Arrays.sort(tokens);
        while(left<=right){
            int oldScore=left - (tokens.length-1-right);
            if(curPower>=tokens[left]){
                curPower-=tokens[left];
                left++;
            }else{
                if(oldScore<1){
                    break;
                }
                curPower+=tokens[right];
                right--;
            }
            int curScore=left - (tokens.length-1-right);
            maxScore=Math.max(maxScore,curScore);
        }
        return maxScore;
    }
}