class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        
        int[][] sortedMat=new int[rows][cols];
        
        //last col
        for(int i=0;i<rows;i++){
            
            int row=i;
            int col=cols-1;
            
            List<Integer> nums=new ArrayList<>();
            
            while(row>=0 && col>=0){
                nums.add(mat[row][col]);
                row--;
                col--;
            }
            
            Collections.sort(nums);
            row++;
            col++;
            int index=0;
            while(row<rows && col<cols){
                sortedMat[row][col]=nums.get(index);
                index++;
                row++;
                col++;
            }
            
        }
        
        //last row
        
        for(int i=0;i<cols;i++){
            
            int row=rows-1;
            int col=i;
            
            List<Integer> nums=new ArrayList<>();
            
            while(row>=0 && col>=0){
                nums.add(mat[row][col]);
                row--;
                col--;
            }
            
            Collections.sort(nums);
            row++;
            col++;
            int index=0;
            while(row<rows && col<cols){
                sortedMat[row][col]=nums.get(index);
                index++;
                row++;
                col++;
            }
            
        }
        
        return sortedMat;
    }
}