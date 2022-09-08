class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int totalValues=values.length;
        int bestSpot=-1;
        int maxScore=0;
        
        for(int i=0;i<totalValues;i++){
            maxScore = Math.max(maxScore,bestSpot+values[i]);
            
            bestSpot = Math.max(bestSpot-1,values[i]-1);
        }
        return maxScore;
    }
}