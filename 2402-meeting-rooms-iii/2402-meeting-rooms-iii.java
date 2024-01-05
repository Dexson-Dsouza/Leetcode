class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        Map<Integer,Integer> meetingCountMap = new HashMap<>();
        
        PriorityQueue<int[]> availableRooms = new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> usedRooms = new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:
                                                                 a[1]-b[1]);
        
        for(int i=0;i<n;i++){
            meetingCountMap.put(i,0);
            availableRooms.add(new int[]{0,i});
        }
        
        for(int[] meeting:meetings){
            int startTime = meeting[0];
            int duration = meeting[1] - meeting[0];
            
            while(usedRooms.size()>0 && usedRooms.peek()[0]<=startTime){
                int[] room = usedRooms.poll();
                availableRooms.add(room);
            }
            
            int[] selectedRoom;
            if(availableRooms.size()>0){
                selectedRoom = availableRooms.poll();
            }else{
                selectedRoom = usedRooms.poll();
                startTime = selectedRoom[0];
            }
            selectedRoom[0] = startTime + duration;
            meetingCountMap.put(selectedRoom[1],meetingCountMap.get(selectedRoom[1])+1);
            usedRooms.add(selectedRoom);
            // System.out.println(selectedRoom[1]+" "+selectedRoom[0]+" "+startTime+" "+(startTime+duration));
        }
        int maxCount = meetingCountMap.get(0);
        int bestRoom = 0;
        for(int i=1;i<n;i++){
            if(meetingCountMap.get(i)>maxCount){
                maxCount=meetingCountMap.get(i);
                bestRoom=i;
            }
        }
        return bestRoom;
        
    }
}