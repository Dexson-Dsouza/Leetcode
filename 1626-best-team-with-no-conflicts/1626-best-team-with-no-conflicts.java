class Player{
    int score;
    int age;
    Player(int score, int age){
        this.score = score;
        this.age = age;
    }
}
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Player> players = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            players.add(new Player(scores[i],ages[i]));
        }
        
        Collections.sort(players,(a,b)->b.age!=a.age?b.age-a.age:b.score-a.score);
        
        int[] dp = new int[scores.length];
        
        int res = 0;
        
        for(int i=0;i<scores.length;i++){
            int curScore = players.get(i).score;
            dp[i] = curScore;
            for(int j=i-1;j>=0;j--){
                int prevScore = players.get(j).score;
                if(curScore<=prevScore)
                    dp[i] = Math.max(dp[i], dp[j] + curScore);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
        
    }
}