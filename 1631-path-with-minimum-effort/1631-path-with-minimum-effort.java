class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        Integer[][] minimumCost=new Integer[rows][cols];
        
        Comparator<int[]> effortComparator=new Comparator<>(){
          public int compare(int[] a, int[] b){
            return a[0]-b[0];   
          }  
        };
        
        PriorityQueue<int[]> currentQueue=new PriorityQueue<>(effortComparator);
        
        currentQueue.add(new int[]{0,0,0});
        minimumCost[0][0]=0;
        
        int[] directions=new int[]{0,-1,0,1,0};
        
        while(currentQueue.size()>0){
            int[] topPoint=currentQueue.poll();
            int maxEffort=topPoint[0];
            int row=topPoint[1];
            int col=topPoint[2];
            // System.out.println(row+" "+col);
            for(int direction=0;direction<4;direction++){
                int nextRow= row+directions[direction];
                int nextCol= col+directions[direction+1];
                
                if(!(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<cols)){
                    continue;
                }
                // System.out.println(nextRow+"_"+nextCol);
                int currentCost=Math.max(maxEffort,Math.abs(heights[row][col] - heights[nextRow][nextCol]));
                if(minimumCost[nextRow][nextCol]==null || currentCost<minimumCost[nextRow][nextCol]){
                    minimumCost[nextRow][nextCol]=currentCost;
                    currentQueue.add(new int[]{currentCost,nextRow,nextCol});
                }                
            }
        }
        
        return minimumCost[rows-1][cols-1];
    }
}