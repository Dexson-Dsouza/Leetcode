class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k+maxPts-1<n){
            return 1;
        }
        double[] prob=new double[n+1];
        
        prob[0]=1;
        double sum=0;
        for(int point=1;point<=k;point++){
            sum += prob[point-1];
            if(point-maxPts-1>=0){
                sum-=prob[point-maxPts-1];
            }
            prob[point]=sum/maxPts;
        }
        double result=prob[k];
        for(int index=k+1;index<=n;index++){
            if(index-maxPts-1>=0){
                sum-=prob[index-maxPts-1];
            }
            result+=sum/maxPts;
        }
        return result;   
    }
}