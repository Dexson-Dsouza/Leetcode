class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols = matrix[0].length;
        
        int top=0;
        int bot=matrix.length-1;
        int row=-1;
        
        while(top<=bot){
            int mid = (top+bot)/2;
            
            if(matrix[mid][0]<=target && target<= matrix[mid][cols-1]){
                row=mid;
                break;
            }else if(target<matrix[mid][0]){
                bot=mid-1;
            }else{
                top=mid+1;
            }
        }
        
        if(row==-1){
            return false;
        }
        
        int left=0,right=cols-1;
        while(left<=right){
            int mid = (left+right)/2;
            
            if(matrix[row][mid]==target){
                return true;
            }else if(target<matrix[row][mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}