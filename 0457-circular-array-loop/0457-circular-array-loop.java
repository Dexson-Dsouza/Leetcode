class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int[] color = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) {
            if(color[i] == 0 && DFS(nums, color, i)) return true;
        }
        return false;
    }
    private boolean DFS(int[] nums, int[] color, int start) {
        //return true if find cycle
        if(color[start] == 2) return false;
        color[start] = 1;
        int next = start + nums[start];
        if(next<0){
            next += ((-next/nums.length) + 1)*nums.length;
        }
        next %= nums.length;
        if(next == start || nums[next] * nums[start] < 0) {
            color[start] = 2;
            return false;
        }
        if(color[next] == 1) {
            color[start] = 2;
            return true;
        }
        if(DFS(nums, color, next)) return true;
        color[start] = 2;
        return false;
    }
}