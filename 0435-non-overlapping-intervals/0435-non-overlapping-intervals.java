class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null)
            return 0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int res=0;
        int prevEnd=intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            int newStart=intervals[i][0];
            if(prevEnd>newStart){
                res++;
                prevEnd=Math.min(prevEnd,intervals[i][1]);
            }else{
                prevEnd=intervals[i][1];
            }
        }
        return res;
    }
}