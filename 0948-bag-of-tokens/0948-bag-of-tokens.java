class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l=0;
        int r=tokens.length-1;
        int score = 0;
        int maxScore=0;
        while(l<=r){
            if(power >= tokens[l]){
                power -= tokens[l];
                score++;
                l++;
            }else{
                if(score==0){
                    break;
                }
                score--;
                power += tokens[r];
                r--;
            }
            maxScore=Math.max(maxScore,score);
        }
        return maxScore;
    }
}