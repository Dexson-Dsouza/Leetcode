class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int[] count=new int[2];
        
        int mod=(int)(Math.pow(10,9)+7);
        
        for(char ch:binary.toCharArray()){
            if(ch=='0'){
                count[0] = ((count[0]>0?count[0]-1:0) + count[1] + 1)%mod; 
            }else{
                count[1] = ((count[0]>0?count[0]-1:0) + count[1] + 1)%mod;
            }
        }
        
        return (int)(count[0]+count[1])%mod;
    }
}