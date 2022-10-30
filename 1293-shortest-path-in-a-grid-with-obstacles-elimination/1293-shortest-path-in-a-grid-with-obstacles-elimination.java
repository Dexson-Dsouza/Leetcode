class gridPoint{
	int r;
	int c; 
	int k;
	gridPoint(int r, int c, int k){
	this.r=r;
	this.c=c;
	this.k=k;
}
}

class Solution {
	int maxSteps=Integer.MAX_VALUE;

public int shortestPath(int[][] grid, int k) {
        	int rows=grid.length;
        	int cols=grid[0].length;
int steps=0;
Queue<gridPoint> gridPoints=new LinkedList<>();
	gridPoints.add(new gridPoint(0,0,k));
    boolean[][][] visited = new boolean[rows][cols][k+1];
	visited[0][0][k]=true;
	while(gridPoints.size()>0){
		int curSize=gridPoints.size();
		for(int i=0;i<curSize;i++){
			gridPoint curPoint=gridPoints.poll();
            // System.out.println(curPoint.r + " "+curPoint.c + " "+curPoint.k);
			if(curPoint.r==rows-1 && curPoint.c==cols-1){
return steps;	
}
for(int dir=0;dir<4;dir++){
	int nextRow=curPoint.r+dirs[dir];
	int nextCol=curPoint.c+dirs[dir+1];
	if(isValid(nextRow,nextCol,grid) && curPoint.k>=grid[nextRow][nextCol] && !visited[nextRow][nextCol][curPoint.k-grid[nextRow][nextCol]]){
visited[nextRow][nextCol][curPoint.k-grid[nextRow][nextCol]]=true;
gridPoints.add(new gridPoint(nextRow,nextCol,curPoint.k-grid[nextRow][nextCol]));

}
}
}	
steps++;

}
return -1;
    	}

	int[] dirs = {0,-1,0,1,0};


boolean isValid(int r, int c, int[][] grid){
	int rows=grid.length;
	int cols=grid[0].length;
	return r>=0 && r<rows && c>=0 && c<cols;
}
}


