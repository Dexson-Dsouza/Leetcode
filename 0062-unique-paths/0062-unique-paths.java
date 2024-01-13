class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] path_count_mat = new Integer[m][n];
        return find_paths(path_count_mat,0,0,m,n);
    }
    
    public int find_paths(Integer[][] path_count_mat, int i, int j, int m,int n){
        if(i<0 || i>=m || j<0|| j>=n){
            return 0;
        }
        
        if(i==m-1 && j==n-1){
            return 1;
        }
        
        if(path_count_mat[i][j]!=null){
            return path_count_mat[i][j];
        }
        
        int unique_path_count=0;
        
        unique_path_count+= find_paths(path_count_mat,i+1,j,m,n);
        unique_path_count+= find_paths(path_count_mat,i,j+1,m,n);
        
        path_count_mat[i][j]=unique_path_count;
        return unique_path_count;
    }
}