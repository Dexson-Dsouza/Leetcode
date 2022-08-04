class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indeg=new int[n];
        
        List<int[]> allRoads=new ArrayList<>();
        for(int[] road:roads){
            indeg[road[0]]++;
            indeg[road[1]]++;
            
            allRoads.add(new int[]{road[0],road[1]});
            allRoads.add(new int[]{road[1],road[0]});
        }
        
        Collections.sort(allRoads,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        
        int roadIndex=0;
        int totalRoads=allRoads.size();
        
        int maxRank=0;
        
        for(int city=0;city<n;city++){
            
            while(roadIndex<totalRoads && allRoads.get(roadIndex)[0]<city){
                roadIndex++;
            }
            
            for(int otherCity=city+1;otherCity<n;otherCity++){
                while(roadIndex<totalRoads && allRoads.get(roadIndex)[0]==city 
                     && allRoads.get(roadIndex)[1]<otherCity){
                    roadIndex++;
                }
                int totalRank = indeg[city] + indeg[otherCity];
                if(roadIndex<totalRoads && allRoads.get(roadIndex)[0]==city && 
                  allRoads.get(roadIndex)[1]==otherCity ){
                    totalRank--;
                }
                // System.out.println(city+" "+otherCity+" "+totalRank +" "+roadIndex);
                maxRank=Math.max(maxRank,totalRank);
            }
            
        }
        return maxRank;
    }
}