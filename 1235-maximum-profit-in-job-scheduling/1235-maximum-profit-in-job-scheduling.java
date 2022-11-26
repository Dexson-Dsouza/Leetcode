public class Job{
    int startTime;
    int endTime;
    int profit;
    Job(int startTime, int endTime, int profit){
        this.startTime=startTime;
        this.endTime=endTime;
        this.profit=profit;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;
        int[] bestPrevIndex=new int[totalJobs];
        
        List<Job> jobList=new ArrayList<>();
        for(int i=0;i<totalJobs;i++){
            jobList.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        
        jobList.sort((a,b)->(a.endTime-b.endTime));
        
        for(int i=0;i<totalJobs;i++){
            int left = 0;
            int right = i-1;
            int curStart = jobList.get(i).startTime;
            int curEnd = jobList.get(i).endTime;
            int prevIndex=-1;
            while(left<=right){
                int mid = (left+right)/2;
                int midEndTime = jobList.get(mid).endTime;
                if(midEndTime<=curStart){
                    prevIndex=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            bestPrevIndex[i]=prevIndex;
        }
        int result=0;
        int[] maxProfitArr=new int[totalJobs];
        for(int i=0;i<totalJobs;i++){
            int prevProfit = i>0? maxProfitArr[i-1]:0;
            int prevIndex=bestPrevIndex[i];
            int prevPossibleProfit = prevIndex == -1? 0 :  maxProfitArr[prevIndex];
            int currentProfit = jobList.get(i).profit;
            
            maxProfitArr[i] = Math.max(prevProfit ,  currentProfit + prevPossibleProfit);
            result=Math.max(result,maxProfitArr[i]);
        }
        return result;
    }
}