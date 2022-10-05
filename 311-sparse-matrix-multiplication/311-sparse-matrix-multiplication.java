class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r1=mat1.length;
        int c1=mat1[0].length;
        int r2=mat2.length;
        int c2=mat2[0].length;
        
        Map<Integer,Set<Integer>> rowElementIndexes=new HashMap<>();
        
        for(int i=0;i<r1;i++){
            if(rowElementIndexes.containsKey(i)==false){
                rowElementIndexes.put(i,new HashSet<>());
            }
            
            for(int j=0;j<c1;j++){
                if(mat1[i][j]!=0){
                    rowElementIndexes.get(i).add(j);
                }
            }
        }
        
        int[][] mul=new int[r1][c2];
        
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                for(int k:rowElementIndexes.get(i)){
                    mul[i][j] += mat1[i][k]*mat2[k][j];
                }
            }
        }
        return mul;
    }
}