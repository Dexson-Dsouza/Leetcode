class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    int[][]dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(char[][]grid,int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length|| grid[i][j]!='1')
            return;
        grid[i][j]='0';
        
        for(int[]dir:dirs){
            int x= i+dir[0];
            int y=j+dir[1];
            
            dfs(grid,x,y);
        }
    }
}