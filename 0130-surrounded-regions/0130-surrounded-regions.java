class Solution {
    public void solve(char[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    // mark open regions touching edges as T
    for (int col = 0; col < cols; col++) {
      if (board[0][col] == 'O') {
        setRegion(board, 0, col, 'T');
      }

      if (board[rows - 1][col] == 'O') {
        setRegion(board, rows - 1, col, 'T');
      }
    }

    for (int row = 0; row < rows; row++) {
      if (board[row][0] == 'O') {
        setRegion(board, row, 0, 'T');
      }

      if (board[row][cols - 1] == 'O') {
        setRegion(board, row, cols - 1, 'T');
      }
    }
    // set all 'O' to 'x'
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == 'O')
          board[row][col] = 'X';
        if (board[row][col] == 'T')
          board[row][col] = 'O';
      }
    }

  }

  public void setRegion(char[][] board, int r, int c, char T) {
    board[r][c] = T;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    for (int[] dir : dirs) {
      int nextRow = r + dir[0];
      int nextCol = c + dir[1];
      if (nextRow >= 0 && nextRow < board.length &&
          nextCol >= 0 && nextCol < board[0].length && board[nextRow][nextCol] == 'O') {
        setRegion(board, nextRow, nextCol, T);
      }
    }
  }
}