class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> flightMap=new HashMap<>();
        
        for(int flight=0;flight<flights.length;flight++){
            int[] curFlight=flights[flight];
            int from=curFlight[0];
            int to=curFlight[1];
            int price=curFlight[2];
            if(flightMap.containsKey(from)==false){
                flightMap.put(from,new ArrayList<>());
            }
            flightMap.get(from).add(new int[]{to,price});
        }
        
        Integer[] costs=new Integer[n];
        costs[src]=0;
        
        Queue<int[]> curStops=new LinkedList<>();
        curStops.add(new int[]{src,0});
        
        int flightPossible=k+1;
        while(flightPossible>0 && curStops.size()>0){
            flightPossible--;
            int curQueueSize=curStops.size();
            // System.out.println(flightPossible+1);
            while(curQueueSize>0){
                curQueueSize--;
                int curStop=curStops.peek()[0];
                int curCost=curStops.peek()[1];
                
                // System.out.println(curStop+" "+curCost);
                curStops.poll();
                
                if(flightMap.containsKey(curStop)==false){
                   continue; 
                }
                
                for(int[] nextflights:flightMap.get(curStop)){
                    int nextStop=nextflights[0];
                    int totalCost=curCost + nextflights[1];
                    // System.out.println(nextStop+"__"+totalCost);
                    if(costs[nextStop]==null || totalCost<costs[nextStop]){
                        costs[nextStop]=totalCost;
                        if(nextStop!=dst){
                            curStops.add(new int[]{nextStop,totalCost});
                        }
                        
                    }
                    
                }
                
            }
            
        }
        return costs[dst]==null?-1:costs[dst];
    }
}