class Solution {
    public int reverse(int x) {
        int reverseNum=0;
        boolean isNegative=false;
        if(x<0){
            isNegative=true;
            if(x==Integer.MIN_VALUE){
                return 0;
            }
            x=Math.abs(x);
        }
        
        while(x!=0){
            int digit=x%10;
            x/=10;
            
            if(isNegative &&  (-1*reverseNum)  < (Integer.MIN_VALUE+digit)/10 ){
                return 0;
            }else if( reverseNum > (Integer.MAX_VALUE - digit)/10) {
                return 0;
            }
            reverseNum = reverseNum*10 + digit;
        }
        if(isNegative){
            reverseNum=reverseNum*-1;
        }
        return reverseNum;
    }
}