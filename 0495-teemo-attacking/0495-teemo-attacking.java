class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int prevPoisonEndTime = -1;
        int time=0;
        for(int t:timeSeries){
            int curPoisonTime = duration;
            if(prevPoisonEndTime>=t){
                time -= prevPoisonEndTime-t+1;
            }
            prevPoisonEndTime = t+duration-1;
            time +=curPoisonTime;
        }
        return time;
    }
}