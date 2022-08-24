class Solution {
    public boolean isPowerOfThree(int n) {
        double a=Math.log(n);
        double b=Math.log(3);
        // System.out.println(a+" "+b);
        // if(a%b!=0){
        //     return false;
        // }
        double pow=a/b;
        // System.out.println(Math.abs(pow-Math.round(pow)));
        return Math.abs(pow-Math.round(pow))<=0.00000000001;
    }
}