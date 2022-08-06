class Solution {
    public String tictactoe(int[][] moves) {
        if(check(0,moves)){
            return "A";
        }
        if(check(1,moves)){
            return "B";
        }
        return moves.length==9?"Draw":"Pending";
    }
    
    public static boolean check(int start, int[][] moves){
        Map<Integer,Integer> rows=new HashMap<>();
        Map<Integer,Integer> cols=new HashMap<>();
        Map<Integer,Integer> diag=new HashMap<>();
        Map<Integer,Integer> antiDiag=new HashMap<>();
        
        for(int i=start;i<moves.length;i+=2){
            int row=moves[i][0];
            int col=moves[i][1];
            int diagSum=row-col;
            int antiDiagSum= row+col;
            rows.put(row,rows.getOrDefault(row,0)+1);
            if(rows.get(row)==3){
                return true;
            }
            cols.put(col,cols.getOrDefault(col,0)+1);
            if(cols.get(col)==3){
                return true;
            }
            diag.put(diagSum,diag.getOrDefault(diagSum,0)+1);
            if(diag.get(diagSum)==3){
                return true;
            }
            antiDiag.put(antiDiagSum,antiDiag.getOrDefault(antiDiagSum,0)+1);
            if(antiDiag.get(antiDiagSum)==3){
                return true;
            }
        }
        return false;
    }
}