class Solution {
    public double myPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        
        if(x==1){
            return x;
        }
        
        if(x==-1){
            if(n%2==0){
                return 1;
            }else{
                return -1;
            }
        }
        double cur=x;
        double power=1;
        long num=n;
        if(n<0){
            x=1/x;
            cur=1/cur;
            num=(long)(n)*-1;
        }
        
        long curPower=1;
        while(curPower*2<num){
            cur = cur*cur;
            curPower*=2;
        }
        
        while(curPower<num){
            curPower++;
            cur *=x;
        }
        return cur;
    }
}