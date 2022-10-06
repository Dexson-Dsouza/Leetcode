class Leaderboard {
    Map<Integer,Integer> playerScoreMap;
    TreeMap<Integer,Integer> scoreCountMap;
    public Leaderboard() {
        playerScoreMap=new HashMap<>();
        scoreCountMap=new TreeMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(playerScoreMap.containsKey(playerId)){
            int currentScore = playerScoreMap.get(playerId);
            update(currentScore);
        }
        playerScoreMap.put(playerId,playerScoreMap.getOrDefault(playerId,0)+score);
        int latestScore=playerScoreMap.get(playerId);
        scoreCountMap.put(latestScore,scoreCountMap.getOrDefault(latestScore,0)+1);
    }
    
    
    public void update(int score){
        scoreCountMap.put(score,scoreCountMap.get(score)-1);
        if(scoreCountMap.get(score)==0){
            scoreCountMap.remove(score);
        }    
    }
    
    public int top(int K) {
        
        // System.out.println(playerScoreMap);
        // System.out.println(scoreCountMap);
        List<Integer> scores = new ArrayList<>(scoreCountMap.keySet());
        int sum=0;
        for(int i=scores.size()-1;i>=0;i--){
            int score = scores.get(i);
            int count=scoreCountMap.get(score);
            int required = Math.min(K,count);
            K-=required;
            sum = sum + score*required;
            if(K==0){
                break;
            }
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int score = playerScoreMap.get(playerId);
        update(score);
        playerScoreMap.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */