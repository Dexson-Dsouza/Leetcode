class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount=0;
        int curLen=0;
        for(int n:nums){
            if(n==0){
                curLen++;
                totalCount+=curLen;
            }else{
                curLen=0;
            }
        }
        return totalCount;
    }
}