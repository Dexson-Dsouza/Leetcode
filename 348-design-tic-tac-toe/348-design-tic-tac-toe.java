class TicTacToe {
    Map<Integer,Map<Integer,Integer>> rowMap;
    Map<Integer,Map<Integer,Integer>> colMap;
    Map<Integer,Map<Integer,Integer>> diagMap;
    Map<Integer,Map<Integer,Integer>> antiDiagMap;
    Boolean end=false;
    int req;
    public TicTacToe(int n) {
        req=n;
        rowMap=new HashMap<>();
        colMap=new HashMap<>();
        diagMap=new HashMap<>();
        antiDiagMap=new HashMap<>();
        for(int i=1;i<=2;i++){
            rowMap.put(i,new HashMap<>());
            colMap.put(i,new HashMap<>());
            diagMap.put(i,new HashMap<>());
            antiDiagMap.put(i,new HashMap<>());
        }
    }
    
    public int move(int row, int col, int player) {
        int diagKey=row+col;
        int antiDiagKey=row-col;
        rowMap.get(player).put(row,rowMap.get(player).getOrDefault(row,0)+1);
        colMap.get(player).put(col,colMap.get(player).getOrDefault(col,0)+1);
        diagMap.get(player).put(diagKey,diagMap.get(player).getOrDefault(diagKey,0)+1);
        antiDiagMap.get(player).put(antiDiagKey,antiDiagMap.get(player).getOrDefault(antiDiagKey,0)+1);
        
        if(rowMap.get(player).get(row)==req){
            end=true;
            return player;
        }
        if(colMap.get(player).get(col)==req){
            end=true;
            return player;
        }
        if(diagMap.get(player).get(diagKey)==req){
            end=true;
            return player;
        }
        if(antiDiagMap.get(player).get(antiDiagKey)==req){
            end=true;
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */