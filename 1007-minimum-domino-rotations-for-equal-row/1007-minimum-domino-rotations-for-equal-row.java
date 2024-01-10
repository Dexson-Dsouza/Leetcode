class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top_value = tops[0];
        int bot_value = bottoms[0];
        
        // CHECK if can make top same
        boolean possible = true;
        
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=top_value && bottoms[i]!=top_value){
                possible = false;
            }
        }
        
        if(possible){
            return findMinimumMoves(tops,bottoms,top_value);
        }
        
        // CHECK if can make bot same
         possible = true;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=bot_value && bottoms[i]!=bot_value){
                possible = false;
            }
        }
        
        if(possible){
            return findMinimumMoves(tops,bottoms,bot_value);
        }
        
        return -1;
    }
    
    int findMinimumMoves(int[] tops, int[] bottoms, int val) {
        int top_rotation_count=0;
        int bot_rotation_count=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=val){
                top_rotation_count++;
            }
            if(bottoms[i]!=val){
                bot_rotation_count++;
            }
            
        }
        return Math.min(bot_rotation_count,top_rotation_count);
    }
}