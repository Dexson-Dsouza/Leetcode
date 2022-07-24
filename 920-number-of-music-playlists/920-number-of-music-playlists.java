class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] ways=new long[goal+1][n+1];
        
        int mod=(int)(Math.pow(10,9)+7);
        ways[0][0]=1;
        for(int num=1;num<=goal;num++){
            for(int song=1;song<=n;song++){
                ways[num][song] = (ways[num-1][song-1]*(n-(song-1)))%mod;
                if(song>k){
                    ways[num][song] = (ways[num][song] + ways[num-1][song]*(song-k))%mod;
                }
            }
        }
        return (int)ways[goal][n];
    }
}