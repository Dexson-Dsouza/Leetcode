class Solution {
      public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n][n];
        return helper(costs, 0, 0, n, memo);
      }

      private int helper(int[][] costs, int a, int b, int n, int[][] memo) {
        if (a + b == n) return 0;
        if (memo[a][b] != 0) return memo[a][b];

        int take = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        if (a < n / 2) take = costs[a + b][0] + helper(costs, a + 1, b, n, memo);
        if (b < n / 2) skip = costs[a + b][1] + helper(costs, a, b + 1, n, memo);
        memo[a][b] = Math.min(take, skip);

        return memo[a][b];
      }
}