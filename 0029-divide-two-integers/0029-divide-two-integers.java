class Solution {
    int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long num = dividend, den = divisor, ans = 0;
        if(num<0){
            num*=-1;
        }
        if(den<0){
            den*=-1;
        }
        int sign = 1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
            sign = -1;
        }
        while (num >= den) {
            long temp = den, m = 1;
            while (temp << 1 <= num) {
                temp <<= 1;
                m <<= 1;
            }
            num -= temp;
            ans += m;
        }
        return (int)(sign * ans);
    }
}