class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        PriorityQueue<int[]> smallest=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        
        for(int i=0;i<rows;i++){
            smallest.add(new int[]{matrix[i][0],i,0});
        }
        
        while(k>1){
            k--;
            int[] smallestPair=smallest.poll();
            
            int row=smallestPair[1];
            int col=smallestPair[2];
            if(col+1<cols){
                smallest.add(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return smallest.poll()[0];
    }
}