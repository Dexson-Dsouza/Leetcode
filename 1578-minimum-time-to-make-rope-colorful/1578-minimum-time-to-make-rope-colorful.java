class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time=0;
        
        int index=0;
        int len=colors.length();
        while(index<len){
            if(index+1<len && colors.charAt(index)==colors.charAt(index+1)){
                int maxTimeBalloon=neededTime[index];
                int sum=neededTime[index];
                index++;
                while(index<len && colors.charAt(index)==colors.charAt(index-1)){
                    sum+=neededTime[index];
                    maxTimeBalloon=Math.max(maxTimeBalloon,neededTime[index]);
                    index++;
                }
                time+=sum-maxTimeBalloon;
            }else{
                index++;
            }
        }
        return time;
    }
}