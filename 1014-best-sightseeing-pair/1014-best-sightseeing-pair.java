class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int totalValues=values.length;
        int[] bestScoreSpotArr=new int[totalValues];
        int maxScore=0;
        
        for(int i=0;i<totalValues;i++){
            if(i>0){
                maxScore = Math.max(maxScore,bestScoreSpotArr[i-1]+values[i]);
            }
            bestScoreSpotArr[i] = Math.max(values[i], (i>0?bestScoreSpotArr[i-1]:0))-1;
        }
        return maxScore;
    }
}