class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] count=new int[1001];
        
        int maxCount=0;
        int maxYear=0;
        for(int log[]:logs){
            int s=log[0]-1950;
            int e=log[1]-1950;
            count[s]++;
            count[e]--;
        }
        
        int curCount=0;
        
        for(int i=0;i<=1000;i++){
            curCount+=count[i];
            if(curCount>maxCount){
                maxCount=curCount;
                maxYear=i;
            }
        }
        return maxYear+1950;
    }
}