class Solution {
    public int reverse(int x) {
        int rev = 0;
        int sign = 1;
        
        if(x<0){
            sign = -1;
            while(x!=0){
                int d = (x-(x/10)*10);
                x/=10;
                // System.out.println(d+" "+x);
                if(rev<(Integer.MIN_VALUE-d)/10){
                    rev = 0;
                    break;
                }
                rev = rev*10 + d;
            }
        }else{
            while(x!=0){
                int d = x%10;
                x/=10;
                if(rev>(Integer.MAX_VALUE-d)/10){
                    rev = 0;
                    break;
                }
                rev = rev*10 + d;
            }
        }
        return rev;
        
    }
}