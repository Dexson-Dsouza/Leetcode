class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> rooms=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int maxRooms=0;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        for(int[] interval : intervals){
            int startTime = interval[0];
            int endTime = interval[1];
            while(rooms.size()>0 && rooms.peek()[1]<=startTime){
                rooms.poll();
            }
            rooms.add(new int[]{startTime,endTime});
            maxRooms=Math.max(maxRooms, rooms.size());
        }
        return maxRooms;
        
    }
}