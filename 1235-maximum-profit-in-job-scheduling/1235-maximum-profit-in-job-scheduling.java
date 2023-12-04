
class Solution {
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
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;

        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < totalJobs; i++) {
          jobList.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        jobList.sort((a, b) -> (a.endTime - b.endTime));

        TreeMap<Integer, Integer> timeProfitMap = new TreeMap<>();
        int maxProfit = 0;
        for (int i = 0; i < totalJobs; i++) {
          int curProfit = jobList.get(i).profit;
          int curStartTime = jobList.get(i).startTime;
          int curEndTime = jobList.get(i).endTime;

          Integer prevBestJobEndTime = timeProfitMap.floorKey(curStartTime);
          if (prevBestJobEndTime != null) {
            curProfit += timeProfitMap.get(prevBestJobEndTime);
          }

          int prevProfit = 0;
          Integer prevCompletedJobEndTime = timeProfitMap.floorKey(curEndTime);
          if (prevCompletedJobEndTime != null) {
            prevProfit = timeProfitMap.get(prevCompletedJobEndTime);
          }
          int curMaxProfit = Math.max(curProfit, prevProfit);
          timeProfitMap.put(curEndTime, curMaxProfit);
          maxProfit = Math.max(maxProfit, curMaxProfit);
        }
        return maxProfit;
      }
}