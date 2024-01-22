class Solution {
    Integer[][] dp;

    public int solve(int i, List<Integer> nums, int t) {
        if (t == 0)
            return 0;
        if (t < 0 || i >= nums.size())
            return -nums.size();
        if (dp[i][t]!=null)
            return dp[i][t];
        int a = 1 + solve(i + 1, nums, t - nums.get(i));
        int b = solve(i + 1, nums, t);
        return dp[i][t] = Math.max(a, b);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        dp = new Integer[n + 1][target + 1];
        int ans = solve(0, nums, target);
        if (ans <= 0)
            return -1;
        return ans;
    }
}