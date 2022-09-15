class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> mergedIntervalList=new ArrayList<>();
        for(int[] interval:intervals){
            if(end>=interval[0]){
                start=Math.min(start,interval[0]);
                end=Math.max(end,interval[1]);
            }else{
                mergedIntervalList.add(new int[]{start,end});
                start=interval[0];
                end=interval[1];
            }
        }
        
        if(mergedIntervalList.size()==0 || mergedIntervalList.get(mergedIntervalList.size()-1)[1]<start){
            mergedIntervalList.add(new int[]{start,end});
        }
        int[][] mergedArr=new int[mergedIntervalList.size()][2];
        for(int i=0;i<mergedIntervalList.size();i++){
            int[] interval=mergedIntervalList.get(i);
            mergedArr[i][0]=interval[0];
            mergedArr[i][1]=interval[1];
        }
        return mergedArr;
    }
}