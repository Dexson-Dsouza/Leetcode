class Solution {
    
    //https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs=0;
        
        int steps = minutesToTest/minutesToDie;
        int states = steps+1;
        
        while(Math.pow(states,pigs)<(double)buckets){
            pigs++;
        }
        return pigs;
    }
}