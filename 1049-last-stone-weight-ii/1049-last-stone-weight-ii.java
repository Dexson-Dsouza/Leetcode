class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int n:stones){
            sum+=n;
        }
        
        int half=sum/2;
        
        boolean[] possibleWeight=new boolean[half+1];
        possibleWeight[0]=true;
        int maxPossibleWeight=0;
        
        for(int weight:stones){
            boolean[] nextPossibleWeight= possibleWeight.clone();
            for(int j=weight;j<=half;j++){
                if(possibleWeight[j-weight]==true){
                    nextPossibleWeight[j]=true;
                    maxPossibleWeight=Math.max(maxPossibleWeight,j);
                }
            }
            possibleWeight=nextPossibleWeight;
        }
        // System.out.println(maxPossibleWeight+" "+sum);
        return (sum-maxPossibleWeight)-maxPossibleWeight;
    }
}