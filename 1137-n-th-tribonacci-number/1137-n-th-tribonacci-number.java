class Solution {
    public int tribonacci(int n) {
        int len=Math.max(n,3);
        int[] res=new int[len+1];
        res[1]=res[2]=1;
        for(int i=3;i<=len;i++){
            res[i]=res[i-1]+res[i-2]+res[i-3];
        }
        return res[n];
    }
}