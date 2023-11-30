class Solution {
public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> zeroCells = new LinkedList<>();
    int rows = mat.length;
    int cols = mat[0].length;
    boolean[][] visited = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (mat[row][col] == 0) {
            visited[row][col]=true;
          zeroCells.add(new int[] { row, col });
        }
      }
    }

    int[][] directionArr = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    int[][] distanceMat = new int[rows][cols];
    int curDistance = 0;
    while (zeroCells.size() > 0) {
      int curQueueSize = zeroCells.size();
      while (curQueueSize > 0) {
        curQueueSize--;
        int[] coord = zeroCells.poll();
        int curRow = coord[0];
        int curCol = coord[1];
        distanceMat[curRow][curCol]= curDistance;
        for (int[] dir : directionArr) {
          int nextRow = curRow + dir[0];
          int nextCol = curCol + dir[1];
          if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols &&
              !visited[nextRow][nextCol]) {
            visited[nextRow][nextCol] = true;
            zeroCells.add(new int[] { nextRow, nextCol });
          }
        }
      }
      curDistance++;
    }
    return distanceMat;
  }
}