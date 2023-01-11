class Solution {
    public int minStartValue(int[] nums) {
        int startVal = 1;
        int sum = 0 ;
        for(int n:nums){
            sum+=n;
            if(sum<0){
                startVal=Math.max(startVal,-sum+1);
            }
        }
        return startVal;
    }
}