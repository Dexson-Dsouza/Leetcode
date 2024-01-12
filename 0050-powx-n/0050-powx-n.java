class Solution {
    double myPow(double x, int num) { 
        long n=num;
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        return calc(x,n);
    }
    
    double calc(double x, long n){
        if(n==0){
            return 1;
        }
        
        double ans = 1;
        
        double half = calc(x,n/2);
        
        if(n%2==1){
            ans = half*half*x;
        }else{
            ans = half*half;
        }
        
        return ans;
        
    }
};