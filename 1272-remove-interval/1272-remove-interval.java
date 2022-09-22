class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> changedIntervals=new ArrayList<>();
        
        for(int[] interval:intervals){
            int from=interval[0];
            int to=interval[1];
            
            if(from<toBeRemoved[0]){
                int start=from;
                int end=Math.min(toBeRemoved[0],to);
                List<Integer> removedInterval=new ArrayList<>();
                removedInterval.add(start);
                removedInterval.add(end);
                changedIntervals.add(removedInterval);
            }
            if(to>toBeRemoved[1]){
                int start=Math.max(toBeRemoved[1],from);
                int end=to;
                List<Integer> removedInterval=new ArrayList<>();
                removedInterval.add(start);
                removedInterval.add(end);
                changedIntervals.add(removedInterval);
            }
        }
        return changedIntervals;
    }
}