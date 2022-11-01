class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer,Integer> count=new HashMap<>();
        int rows=mat.length;
        int cols=mat[0].length;
        for(int col = 0; col < cols; col++){
            for(int row = 0; row < rows; row++){
                int curVal=mat[row][col];
                count.put(curVal,count.getOrDefault(curVal,0)+1);
                if(count.get(curVal)==rows){
                    return curVal;
                }
            }
        }
        return -1;
    }
}