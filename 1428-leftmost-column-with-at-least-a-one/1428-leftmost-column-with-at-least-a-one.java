/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);
        
        
        
        int curCol = cols-1;
        int curRow = 0;
        while(curRow<rows && binaryMatrix.get(curRow,curCol)==0){
            curRow++;
        }
        if(curRow==rows){
            return -1;
        }
        
        int bestCol = curCol;
        for(int row=curRow;row<rows;row++){
            int left = 0;
            int right = cols-1;
            int leftMostOne = cols;
            while(left<=right){
                int mid = (left+right)/2;
                if(binaryMatrix.get(row,mid)==1){
                    leftMostOne=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            bestCol = Math.min(bestCol,leftMostOne);
        }
        return bestCol;
    }
}