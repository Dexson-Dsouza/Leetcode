class Solution {
    public int numSquares(int n) {
        int squareRoot=(int)(Math.sqrt(n));
        Integer[] steps=new Integer[n+1];
        steps[0]=0;
        for(int i=1;i<=squareRoot;i++){
            int curNum=i*i;
            for(int j=curNum;j<=n;j++){
                if(steps[j-curNum]!=null && (steps[j]==null || steps[j-curNum]+1<steps[j])){
                    steps[j]=steps[j-curNum]+1;
                }
            }
        }
        return steps[n];
    }
}