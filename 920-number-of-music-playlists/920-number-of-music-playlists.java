class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] ways=new long[goal+1][n+1];
        ways[0][0]=1;
        int mod=(int)(Math.pow(10,9)+7);
        for(int curGoal=1;curGoal<=goal;curGoal++){
            for(int choice=1;choice<=n;choice++){
                ways[curGoal][choice] =( ways[curGoal-1][choice-1] * (n-choice+1))%mod;
                if(choice>k){
                    ways[curGoal][choice] = (ways[curGoal][choice]+ ways[curGoal-1][choice]*(choice-k)%mod )%mod;
                }
            }
        }
        return (int)(ways[goal][n]%mod);
    }
}


// 1 2 3

// 3 * 2 * 1 + 