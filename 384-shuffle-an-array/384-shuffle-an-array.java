class Solution {
    int[] og;
    int[] cur;
    public Solution(int[] nums) {
        og=nums;
        cur=og.clone();
    }
    
    public int[] reset() {
        cur=og.clone();
        return cur;
    }
    
    public int[] shuffle() {
        for(int i=0;i<cur.length;i++){
            int randIndex=(int)(Math.random()*(cur.length-i)+i);
            int t=cur[randIndex];
            cur[randIndex] = cur[i];
            cur[i]=t;
        }
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */