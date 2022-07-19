class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> leftIntervals=new ArrayList<>();
        
        int removedStart=toBeRemoved[0];
        int removedEnd=toBeRemoved[1];
        
        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];
            
            if(start<removedStart && end >removedEnd){
                List<Integer> startInterval=new ArrayList<>();
                startInterval.add(start);
                startInterval.add(removedStart);
                leftIntervals.add(startInterval);
                List<Integer> endInterval=new ArrayList<>();
                
                endInterval.add(removedEnd);
                endInterval.add(end);
                leftIntervals.add(endInterval);
            }else if(start<removedStart){
                List<Integer> startInterval=new ArrayList<>();
                startInterval.add(start);
                startInterval.add(Math.min(removedStart,end));
                leftIntervals.add(startInterval);
            }else if(end>removedEnd){
                List<Integer> endInterval=new ArrayList<>();
                endInterval.add(Math.max(removedEnd,start));
                endInterval.add(end);
                leftIntervals.add(endInterval);
            }
            
        } 
        return leftIntervals;
    }
}