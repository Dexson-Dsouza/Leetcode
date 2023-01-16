class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals=new ArrayList<>();
        
        int newIntervalStart=newInterval[0];
        int newIntevalEnd=newInterval[1];
        
        for(int[] interval:intervals){
            // System.out.println(newIntervalStart+" "+newIntevalEnd);
            if(newIntervalStart<=interval[1] && newIntevalEnd>=interval[0]){
                newIntevalEnd=Math.max(newIntevalEnd,interval[1]);
                newIntervalStart=Math.min(newIntervalStart,interval[0]);
            }else if(newIntervalStart<interval[0]){
                newIntervals.add(new int[]{newIntervalStart,newIntevalEnd});
                newIntervalStart=interval[0];
                newIntevalEnd=interval[1];
            }else {
                
                newIntervals.add(interval);
            }
        }
        
        if(newIntervals.size()==0 || newIntervals.get(newIntervals.size()-1)[1]<newIntervalStart){
            newIntervals.add(new int[]{newIntervalStart,newIntevalEnd});
        }
        
        int size=newIntervals.size();
        int[][] resultIntervals=new int[size][2];
        
        for(int i=0;i<size;i++){
            resultIntervals[i][0]=newIntervals.get(i)[0];
            resultIntervals[i][1]=newIntervals.get(i)[1];
        }
        return resultIntervals;
    }
}