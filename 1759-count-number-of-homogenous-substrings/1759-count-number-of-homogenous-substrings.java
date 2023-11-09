class Solution {
    public int countHomogenous(String s) {
        int curStreak = 0;
        int ans = 0;
        int mod = (int)(Math.pow(10,9)+7);
        for(int i=0; i<s.length();i++){
            if(i==0 || s.charAt(i)==s.charAt(i-1)){
                curStreak++;
            }else{
                curStreak=1;
            }
            ans=(ans+curStreak)%mod;
        }
        return ans;
    }
}