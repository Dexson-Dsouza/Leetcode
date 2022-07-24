class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k+maxPts-1<n || k==0){
            return 1;
        }
        double[] prob= new double[n+1];
        prob[0]=1;
        
        double result=0;
        double sum=1;
        for(int i=1;i<=n;i++){
            prob[i]=sum/maxPts;
            
            if(i>=maxPts){
                sum-=prob[i-maxPts];
            }
            
            
            if(i<k){
                sum +=prob[i];
            }else{
                result += prob[i];
            }
        }
        return result;
    }
}