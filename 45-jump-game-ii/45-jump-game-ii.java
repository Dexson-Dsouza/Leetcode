class Solution {
    public int jump(int[] nums) {
        int inputSize=nums.length;
        int[] minimumJumpToReach= new int[inputSize];
        
        Arrays.fill(minimumJumpToReach,Integer.MAX_VALUE);
        minimumJumpToReach[0]=0;
        
        for(int i=0;i<inputSize;i++){
            if(minimumJumpToReach[i]==Integer.MAX_VALUE){
                break;
            }
            
            for(int j=i;j<=Math.min(inputSize-1,i+nums[i]);j++){
                minimumJumpToReach[j] = Math.min(minimumJumpToReach[j], 1 + minimumJumpToReach[i]);
            }
        }
        return minimumJumpToReach[inputSize-1];
    }
}