class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        Map<Integer,Set<Integer>> busDestMap=new HashMap<>();
        Map<Integer,Set<Integer>> destBusMap=new HashMap<>();
        // build adj 
        for(int bus=0;bus<routes.length;bus++){
            int[] route=routes[bus];
            for(int i=0;i<route.length;i++){
                addToAdj(bus,route[i],busDestMap);
                addToAdj(route[i],bus,destBusMap);
            }
        }
        
        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        Set<Integer> visitedBuses = new HashSet<>();
        Queue<Integer> curBuses = new LinkedList<>();
        
        if(!destBusMap.containsKey(source)){
            return -1;
        }
        
        for(int b:destBusMap.get(source)){
            curBuses.add(b);
            visitedBuses.add(b);
        }
        int busCount=1;
        // start bfs
        while(curBuses.size()>0){
            int size = curBuses.size();
            while(size>0){
                size--;
                int curBus = curBuses.poll();
                for(int stop:busDestMap.get(curBus)){
                    
                    if(stop==target){
                        return busCount;
                    }
                    
                    for(int nextBus:destBusMap.get(stop)){
                        if(!visitedBuses.contains(nextBus)){
                            visitedBuses.add(nextBus);
                            curBuses.add(nextBus);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
    
    void addToAdj(int from, int to, Map<Integer,Set<Integer>> adjMap){
        if(!adjMap.containsKey(from)){
            adjMap.put(from,new HashSet<>());
        }
        adjMap.get(from).add(to);
    }
}