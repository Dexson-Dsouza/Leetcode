/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] directions= new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited=new HashSet<>();
        dfs(robot,0,0,visited,0);
    }
    
    void dfs(Robot robot, int row, int col, Set<String> visited, int dir){
        String key=row+","+col;
        visited.add(key);
        robot.clean();
        for(int nextDir=0;nextDir<4;nextDir++){
            int nextDirIndex= (dir+nextDir)%4;
            int nr=row+directions[nextDirIndex][0];
            int nc=col+directions[nextDirIndex][1];
            String nextKey=nr+","+nc;
            if(visited.contains(nextKey)==false && robot.move()==true){
                dfs(robot,nr,nc,visited,nextDirIndex);        
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}