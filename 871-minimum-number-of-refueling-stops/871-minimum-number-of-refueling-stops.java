class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> gasStations =new PriorityQueue<>((a,b)->b-a);
        
        int curPos=startFuel;
        
        int refuelCount=0;
        int stationIndex=0;
        while(curPos<target){
            while(stationIndex<stations.length && stations[stationIndex][0]<=curPos){
                gasStations.add(stations[stationIndex++][1]);
            }
            if(gasStations.size()==0){
                break;
            }
            curPos+=gasStations.poll();
            refuelCount++;
        }
        return curPos<target?-1:refuelCount;
    }
}