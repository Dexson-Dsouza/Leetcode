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
        Queue<Integer> curStops = new LinkedList<>();
        curStops.add(source);
        int busCount=1;
        // start bfs
        while(curStops.size()>0){
            int size = curStops.size();
            while(size>0){
                size--;
                int curStop = curStops.poll();
                if(!destBusMap.containsKey(curStop)){
                    continue;
                }
                for(int bus:destBusMap.get(curStop)){
                    if(visitedBuses.contains(bus)){
                        continue;
                    }
                    visitedBuses.add(bus);
                    if(busDestMap.get(bus).contains(target)){
                        return busCount;
                    }
                    for(int nextStop:busDestMap.get(bus)){
                        // if(!visitedStops.contains(nextStop)){
                            visitedStops.add(nextStop);
                            curStops.add(nextStop);
                        // }
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