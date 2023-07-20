class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int count = 0;
        int prevEnd = intervals[0][1];
        int cur = 1;
        while(cur<intervals.length){
            
            int curStart = intervals[cur][0];
            if(curStart>=prevEnd){
                prevEnd=intervals[cur][1];
                cur++;
            }else{
                prevEnd= Math.min(prevEnd,intervals[cur][1]);
                count++;
                cur++;
            }
            
        }
        return count;
    }
}