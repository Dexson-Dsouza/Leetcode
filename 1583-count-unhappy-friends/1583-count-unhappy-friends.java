class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] preferenceRank=new int[n][n];
        
        for(int i=0;i<n;i++){
            int curPerson=i;
            for(int j=0;j<n-1;j++){
                int preferredPerson=preferences[i][j];
                preferenceRank[curPerson][preferredPerson]=j;
            }
        }
        
        int unhappyCount=0;
        int[] pairArr=new int[n];
        for(int pair[]:pairs){
            int x=pair[0];
            int y=pair[1];
            pairArr[x]=y;
            pairArr[y]=x;
        }
        
        
        for(int i=0;i<n;i++){
            int currentPerson = i;
            int pairedPerson = pairArr[i];
            
            int j=0;
            while(preferences[currentPerson][j]!=pairedPerson){
                int preferredPerson = preferences[currentPerson][j];
                int preferredPersonPair = pairArr[preferredPerson];
                
                int preferenceForCurrent = preferenceRank[preferredPerson][currentPerson];
                int preferredPersonPairPreference = preferenceRank[preferredPerson][preferredPersonPair];
                if(preferenceForCurrent<preferredPersonPairPreference){
                    unhappyCount++;
                    break;
                }
                j++;
            }
            
        }
        return unhappyCount;
    }
}