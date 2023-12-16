class Solution {

      int maximumDetonation(int[][] bombs) {
        int n = bombs.length, ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, new boolean[n], bombs));
        }
        return ans;
    }

     int dfs(int idx, boolean[] v, int[][] bombs) {
        int count = 1;
        v[idx] = true;
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            if (!v[i] && inRange(bombs[idx], bombs[i])) {
                count += dfs(i, v, bombs);
            }
        }
        return count;
    }

     boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }
};