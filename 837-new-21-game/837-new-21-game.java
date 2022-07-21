class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k+maxPts-1<n || k==0){
            return 1;
        }
        double[] prob=new double[n+1];
        
        prob[0]=1;
        double sum=1;
        double result=0;
        for(int point=1;point<=n;point++){
            prob[point]=sum/maxPts;
            
            if(point>=k){
                result+=prob[point];
            }else{
                sum+=prob[point];
            }
            if(point-maxPts>=0){
                sum-=prob[point-maxPts];
            }
        }
        return result;   
    }
}