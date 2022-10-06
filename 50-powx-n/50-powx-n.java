class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
        if(x==1 ){
            return 1;
        }
        if(x==-1){
            return n%2==0?1:-1;
        }
        boolean isMin=false;
        if(n<0){
            x=1/x;
            if(n==Integer.MIN_VALUE){
                isMin=true;
                n=Integer.MAX_VALUE;
            }else{
                n=Math.abs(n);
            }
        }
        int curPow=1;
        double result=x;
        while(curPow <= n/2){
            curPow*=2;
            result=result*result;
        }
        
        while(curPow != n){
            result*=x;
            curPow++;
        }
        if(isMin){
            result*=x;
        }
        return result;
    }
}