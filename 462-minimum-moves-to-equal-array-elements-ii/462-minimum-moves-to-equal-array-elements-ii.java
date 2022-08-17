class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long curMoves=0;
        for(int n:nums){
            curMoves+=Math.abs(n-nums[0]);
        }
        long minMoves=curMoves;
        for(int i=1;i<nums.length;i++){
            
            // System.out.println(curMoves+" "+minMoves);
            curMoves = curMoves + i*Math.abs(nums[i]-nums[i-1]) - Math.abs(nums[i]-nums[i-1])*(nums.length-i);
            minMoves = Math.min(minMoves,curMoves);
            // System.out.println(curMoves+" "+minMoves);
        }
        return (int)minMoves;
    }
}