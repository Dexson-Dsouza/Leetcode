class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count=new int[60];
        int pairs=0;
        for(int t:time){
            pairs += count[(60-(t%60))%60];
            count[t%60]++;
        }
        return pairs;
    }
}