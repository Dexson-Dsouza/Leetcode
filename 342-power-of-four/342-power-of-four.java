class Solution {
    public boolean isPowerOfFour(int n) {
        long cur=1;
        while(cur<n){
            cur<<=1;
            cur<<=1;
        }
        return cur==n;
    }
}