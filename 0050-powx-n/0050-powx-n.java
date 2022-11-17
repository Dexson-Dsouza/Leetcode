class Solution {
    double myPow(double x, int num) { 
        long n=num;
        if(n==0) return 1;
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while(n>0){
            if(n%2 ==1){
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;
    }
};