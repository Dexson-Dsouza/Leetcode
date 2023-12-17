class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
        int count=0;
        int prevEnd= intervals[0][1];
        
        for(int i=1;i<intervals.length;i++){
            if(prevEnd>intervals[i][0]){
                count++;
            }
            else{
                prevEnd=intervals[i][1];
            }
        }
        return count;
    }
}