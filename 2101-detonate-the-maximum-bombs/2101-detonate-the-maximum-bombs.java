class Solution {
    public int maximumDetonation(int[][] bombs) {
        int total = bombs.length;
        int maxCount = 0;
        for(int i=0;i<total;i++){
            boolean[] visited= new boolean[total];
            int count = dfs(visited,i,bombs);
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
    
    int dfs(boolean[] visited, int index, int[][] bombs){
        if(visited[index]){
            return 0;
        }
        visited[index]=true;
        int count = 1;
        for(int i=0;i<bombs.length;i++){
            if(i==index || visited[i]){
                continue;
            }
            if(inRange(bombs,i,index)){
                count+= dfs(visited,i,bombs);
            }
        }
        return count;
    }
    
    boolean inRange(int[][] bombs, int i,int j){
        double dist = Math.sqrt(Math.pow(bombs[i][0]-bombs[j][0],2) 
                                + Math.pow(bombs[i][1]-bombs[j][1],2));
        double radius = (double)(bombs[j][2]);
        return radius>=dist;
    }
}