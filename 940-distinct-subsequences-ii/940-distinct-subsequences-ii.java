class Solution {
    public int distinctSubseqII(String s) {
        long[] cnt=new long[26];
        long res=0;
        int mod=(int)(Math.pow(10,9)+7);
        
        for(char c:s.toCharArray()){
            long total=0;
            for(int i=0;i<26;i++){
                total= (total+ cnt[i])%mod;
            }
            
            cnt[c-'a']= (total+1)%mod;
            // System.out.println(cnt[c-'a']);
        }
        
        for(int i=0;i<26;i++){
            res = (res+ cnt[i])%mod;
        }
        return (int)(res);
    }
}