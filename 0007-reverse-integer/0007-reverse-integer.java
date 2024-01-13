class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while(x!=0){
            int lastDigit = x%10;
            x/=10;
            
            // checks for positive num
            if(lastDigit>0 &&  rev  > (Integer.MAX_VALUE-lastDigit)/10){
                return 0;
            }
            // checks for negative num
            if(lastDigit<0 && rev < (Integer.MIN_VALUE-lastDigit)/10 ){
                return 0;
            }
            
            rev = rev *10 + lastDigit;
        }
        
        return rev;
    }
}