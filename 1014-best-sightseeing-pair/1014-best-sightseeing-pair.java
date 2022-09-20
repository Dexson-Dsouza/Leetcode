class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        Deque<int[]> bestPrevSpots=new LinkedList<>();
        
        bestPrevSpots.add(new int[]{values[0],0});
        
        int bestScore=0;
        
        for(int i=1;i<values.length;i++){
            int[] prevSpot = bestPrevSpots.peekFirst();
            int curScore = values[i] + prevSpot[0] + (prevSpot[1]-i);
            bestScore=Math.max(bestScore,curScore);
            
            int curSpotScore = i+values[i];
            while(bestPrevSpots.size()>0 && (bestPrevSpots.peekFirst()[1]+bestPrevSpots.peekFirst()[0])<=curSpotScore){
                bestPrevSpots.pollFirst();
            }
            bestPrevSpots.add(new int[]{values[i],i});
        }
        return bestScore;
    }
}