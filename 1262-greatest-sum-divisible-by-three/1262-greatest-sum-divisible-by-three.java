class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] remainders=new int[3];
        
        for(int n:nums){
            int[] nextRemainders=remainders.clone();
            for(int i=0;i<3;i++){
                int sum = remainders[i]+n;
                
                int mod = sum%3;
                nextRemainders[mod]=Math.max(nextRemainders[mod],sum);
            }
            remainders=nextRemainders;
        }
        return remainders[0];
    }
}