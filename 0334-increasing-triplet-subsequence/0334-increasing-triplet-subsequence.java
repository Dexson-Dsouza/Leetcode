class Solution {
    public boolean increasingTriplet(int[] nums) {
        int f=Integer.MAX_VALUE-1,s=Integer.MAX_VALUE;
        
        for(int t:nums){
            if(t>s && s>f ){
                return true;
            }else if(t<s && t>f){
                s = t;
            }else if(t<f){
                f = t;
            }
            
        }
        return false;
    }
}