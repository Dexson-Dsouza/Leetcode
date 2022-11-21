class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows=maze.length;
        int cols=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        int steps=0;
        q.add(entrance);
        while(q.size()>0){
            steps++;
            int curSize=q.size();
            while(curSize>0){
                curSize--;
                int row=q.peek()[0];
                int col=q.peek()[1];
                maze[row][col]='+';
                q.poll();
                for(int[] point:getNeighBours(row,col)){
                    int nr=point[0];
                    int nc=point[1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && maze[nr][nc]!='+'){
                        if(nr==0 || nr==rows-1 || nc==0 || nc==cols-1){
                            return steps;
                        }
                        maze[nr][nc]='+';
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return -1;
    }
    
    public List<int[]> getNeighBours(int r,int c){
        int[] dirs=new int[]{0,-1,0,1,0};
        List<int[]> points=new ArrayList<>();
        for(int i=0;i<4;i++){
            points.add(new int[]{r+dirs[i],c+dirs[i+1]});
        }
        return points;
    }
}