class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        
        Integer[][] max_path_mat = new Integer[rows][cols];
        
        int max_len = 0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max_len = Math.max(max_len,find_max_path(mat,i,j,max_path_mat));
            }
        }
        return max_len;
    }
    
    int[][] directions =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    int find_max_path(int[][] mat, int i, int j, Integer[][] max_path_mat){
        
        
        if(max_path_mat[i][j]!=null){
            return max_path_mat[i][j];
        }
        
        int max_len = 1;
        for(int[] dir:directions){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr<0 || nr>=mat.length || nc<0 || nc>=mat[0].length || mat[nr][nc]<=mat[i][j]){
                continue;
            }
            max_len = Math.max(max_len, 1 + find_max_path(mat,nr,nc,max_path_mat));
        }
        return max_path_mat[i][j] = max_len;
        
    }
}