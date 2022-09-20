class UndergroundSystem {
    Map<Integer,String> stationNames;
    Map<Integer,Integer> inTime;
    Map<String,Map<String,Double>> totalTravelTime;
    Map<String,Map<String,Integer>> totalPassengers;
    
    public UndergroundSystem() {
        stationNames=new HashMap<>();
        inTime=new HashMap<>();
        totalTravelTime=new HashMap<>();
        totalPassengers=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        inTime.put(id,t);
        stationNames.put(id,stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String from = stationNames.get(id);
        int checkInTime = inTime.get(id);
        int travelTime = t-checkInTime;
        if(totalTravelTime.containsKey(from)==false){
            totalTravelTime.put(from,new HashMap<>());
            totalPassengers.put(from,new HashMap<>());
        }
        Map<String,Double> sourceTravelMap=totalTravelTime.get(from);
        Map<String,Integer> sourcePassengerMap=totalPassengers.get(from);
        sourceTravelMap.put(stationName,sourceTravelMap.getOrDefault(stationName,0.0)+travelTime);
        sourcePassengerMap.put(stationName,sourcePassengerMap.getOrDefault(stationName,0)+1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        if(totalTravelTime.containsKey(startStation)==false){
             return 0;
        }
        if(totalTravelTime.get(startStation).containsKey(endStation)==false){
             return 0;
        }
        Double t=totalTravelTime.get(startStation).get(endStation);
        int countOfPassengers= totalPassengers.get(startStation).get(endStation);
        return totalTravelTime.get(startStation).get(endStation)/countOfPassengers;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */