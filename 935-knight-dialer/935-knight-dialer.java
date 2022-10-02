class Solution {
    public int knightDialer(int n) {
        int[] perm=new int[10];
        
        Arrays.fill(perm,1);
        int[][] reachable=new int[][]{{4,6},{8,6},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{4,2}};
        int mod=(int)(Math.pow(10,9)+7);
        
        while(n>1){
            int[] nextPerm=new int[10];
            for(int i=0;i<10;i++){
                for(int nextNum:reachable[i]){
                    nextPerm[nextNum] = (nextPerm[nextNum] + perm[i])%mod;
                }
            }
            perm = nextPerm;
            n--;
        }
    
        int total=0;
        for(int i=0;i<10;i++){
            total = (total+perm[i])%mod;
        }
        return total;
    }
}