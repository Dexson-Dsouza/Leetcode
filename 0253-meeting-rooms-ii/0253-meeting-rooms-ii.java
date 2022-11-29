class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer,Integer> meetingTimeMap=new TreeMap<>();
        int maxRooms=0;
        
        for(int[] interval : intervals){
            int startTime = interval[0];
            int endTime = interval[1];
            meetingTimeMap.put(startTime,meetingTimeMap.getOrDefault(startTime,0)+1);
            meetingTimeMap.put(endTime,meetingTimeMap.getOrDefault(endTime,0)-1);
        }
        int currentRooms=0;
        for(Map.Entry<Integer,Integer> key : meetingTimeMap.entrySet()){
            // System.out.println(key.getKey() + " "+ key.getValue());
            currentRooms += key.getValue();
            maxRooms=Math.max(currentRooms,maxRooms);
        }
        return maxRooms;
        
    }
}