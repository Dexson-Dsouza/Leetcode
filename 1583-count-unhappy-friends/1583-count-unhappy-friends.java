class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];
        Map<Integer,Integer> pairMap = new HashMap<>();
        
        for(int[] pair:pairs){
            pairMap.put(pair[0],pair[1]);
            pairMap.put(pair[1],pair[0]);
        }
        
        for(int i=0;i<preferences.length;i++){
            int x = i;
            for(int j=0;j<preferences[i].length;j++){
                int y = preferences[i][j];
                int preferenceRank = j;
                rank[i][y] = preferenceRank;
            }
        }
        
        int countOfUnhappyFriends=0;
        
        for(int[] pair:pairs){
            int friend1 = pair[0];
            int friend2 = pair[1];
            if(isUnhappy(friend1,friend2,preferences,rank,pairMap)){
                countOfUnhappyFriends++;
            }
            if(isUnhappy(friend2,friend1,preferences,rank,pairMap)){
                countOfUnhappyFriends++;
            }
        }
        
        return countOfUnhappyFriends;
    }
    
    boolean isUnhappy(int x, int y, int[][] preferences, int[][] rank, Map<Integer,Integer> pairMap){
        int rankY = rank[x][y];
        
        for(int i=0;i<rankY;i++){
            int person = preferences[x][i];
            int personPair = pairMap.get(person);
            
            int preferenceX = rank[person][x];
            int preferencePair = rank[person][personPair];
            if(preferenceX<preferencePair){
                // System.out.println(x);
                return true;
            }
        }
        
        return false;
    }
}