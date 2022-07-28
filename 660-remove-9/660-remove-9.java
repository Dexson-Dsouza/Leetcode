class Solution {
    public int newInteger(int n) {
        int result=0;
        int pow=1;
        while(n!=0){
            int last=n%9;
            result = result + last*pow;
            pow = pow*10;
            n/=9;
        }
        return result;
    }
}