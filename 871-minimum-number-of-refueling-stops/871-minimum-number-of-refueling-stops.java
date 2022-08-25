class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int stops=0;
        int index=0;
        int curDist=startFuel;
        while(curDist<target){
            while(index<stations.length && stations[index][0]<=curDist){
                pq.add(stations[index++]);
            }
            
            if(pq.size()>0){
                curDist+=pq.poll()[1];
                stops++;
            }else{
                break;
            }
        }
        return curDist<target?-1:stops;
    }
}