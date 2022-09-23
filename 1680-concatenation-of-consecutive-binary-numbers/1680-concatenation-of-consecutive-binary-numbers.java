class Solution {
    public int concatenatedBinary(int n) {
        int cur=1;
        int mod=(int)(Math.pow(10,9)+7);
        
        int res=0;
        
        for(int i=n;i>=1;i--){
            
            int pow=0;
            while(1<<pow < i){
                pow++;
            }
            if(1<<pow>i){
                pow--;
            }
            for(int p=0;p<=pow;p++){
                // System.out.print(((1<<p)&i)==0?0:1);
                if(((1<<p)&i)!=0){
                    res = (res + cur)%mod;
                }
                cur = (cur*2)%mod;
            }
            
            // System.out.println(" "+pow+" "+i +'\n');
        }
        return res%mod;
    }
}