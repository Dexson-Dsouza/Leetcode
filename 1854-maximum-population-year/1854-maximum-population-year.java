class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] count=new int[2051];
        
        int maxCount=0;
        int maxYear=0;
        for(int log[]:logs){
            int s=log[0];
            int e=log[1];
            count[s]++;
            count[e]--;
        }
        
        int curCount=0;
        
        for(int i=0;i<=2050;i++){
            curCount+=count[i];
            if(curCount>maxCount){
                maxCount=curCount;
                maxYear=i;
            }
        }
        return maxYear;
    }
}