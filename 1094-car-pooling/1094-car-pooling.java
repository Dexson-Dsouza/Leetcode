class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int curCap=0;
        
        PriorityQueue<int[]> passengers=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        
        for(int[] trip:trips){
            int startTime=trip[1];
            int endTime=trip[2];
            int groupSize=trip[0];
            
            while(passengers.size()>0 && passengers.peek()[0]<=startTime){
                curCap-=passengers.peek()[1];
                passengers.poll();
            }
            
            curCap+=groupSize;
            if(curCap>capacity){
                return false;
            }
            passengers.add(new int[]{endTime,groupSize});
        }
        return true;
    }
}