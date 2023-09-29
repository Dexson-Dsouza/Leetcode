class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int count = 0;
        int curSum = 0;
        for(int n:nums){
            curSum+=n;
            int rem = curSum-k;
            count += preSum.getOrDefault(rem,0);
            preSum.put(curSum,preSum.getOrDefault(curSum,0)+1);
        }
        return count;
    }
}