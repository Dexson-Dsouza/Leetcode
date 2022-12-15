class Solution {
    public int totalNQueens(int n) {
    
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        Set<Integer> cols=new HashSet<>();
        Set<Integer> daig=new HashSet<>();
        Set<Integer> antiDaig=new HashSet<>();
        return dfs(arr,0,n,cols,daig,antiDaig);
    }
    
    int dfs(char[][] arr, int row, int n,Set<Integer> cols, Set<Integer> daig, Set<Integer> antiDaig){
        if(row==n){
            // System.out.println("'res'");
            return 1;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int col=i;
            int cur_daig= row+i;
            int cur_antiDaig= row-i;
            if(!cols.contains(col) && !daig.contains(cur_daig) && !antiDaig.contains(cur_antiDaig)){
                cols.add(col);
                daig.add(cur_daig);
                antiDaig.add(cur_antiDaig);
                arr[row][i]='Q';
                count += dfs(arr,row+1,n,cols,daig,antiDaig);
                arr[row][i]='.';
                cols.remove(col);
                daig.remove(cur_daig);
                antiDaig.remove(cur_antiDaig);
            }
        }
        return count;
    }
}