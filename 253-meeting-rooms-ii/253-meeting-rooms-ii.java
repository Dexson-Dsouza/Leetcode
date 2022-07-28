class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int count=0;
        for(int[] meeting:intervals){
            int start=meeting[0];
            int end=meeting[1];
            while(pq.size()>0 && pq.peek()<=start){
                pq.poll();
            }
            pq.add(end);
            count=Math.max(count,pq.size());
        }
        return count;
    }
}