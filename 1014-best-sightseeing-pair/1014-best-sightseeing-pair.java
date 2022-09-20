class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        Deque<int[]> bestPrevSpots=new LinkedList<>();
        
        int bestPrevScore = values[0];
        int bestScore=0;
        
        for(int i=1;i<values.length;i++){
            int curScore = values[i] + bestPrevScore -i;
            bestScore=Math.max(bestScore,curScore);
            
            bestPrevScore=Math.max(bestPrevScore,values[i]+i);    
        }
        return bestScore;
    }
}