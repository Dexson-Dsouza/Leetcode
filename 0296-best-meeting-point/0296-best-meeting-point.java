class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xPoints=new ArrayList<>();
        List<Integer> yPoints=new ArrayList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int xSum=0;
        int ySum=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    xPoints.add(i);
                    yPoints.add(j);
                    xSum+=i;
                    ySum+=j;
                }
            }
        }
        
        Collections.sort(xPoints);
        Collections.sort(yPoints);
        int meetingPointX = xPoints.get(xPoints.size() / 2);
        int meetingPointY = yPoints.get(yPoints.size() / 2);
        int distance=0;
        for(int x:xPoints){
            distance+=Math.abs(x-meetingPointX);
        }
        for(int y:yPoints){
            distance+=Math.abs(y-meetingPointY);
        }
        return distance;
    }
}