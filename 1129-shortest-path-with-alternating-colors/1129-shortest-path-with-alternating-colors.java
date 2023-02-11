class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] pathArr=new int[n][2];
        Map<Integer,Set<Integer>> redAdj=new HashMap<>();
        Map<Integer,Set<Integer>> blueAdj=new HashMap<>();
        
        for(int i=0;i<n;i++){
            redAdj.put(i,new HashSet<>());
            blueAdj.put(i,new HashSet<>());
        }
        
        for(int[] edge:redEdges){
            int from = edge[0];
            int to = edge[1];
            // if(from == to){
            //     continue;
            // }
            redAdj.get(from).add(to);
        } 
        for(int[] edge:blueEdges){
            int from = edge[0];
            int to = edge[1];
            // if(from == to){
            //     continue;
            // }
            blueAdj.get(from).add(to);
        } 
        for(int[] p : pathArr){
            Arrays.fill(p,Integer.MAX_VALUE);
        }
        
        findDistance(0,0,redAdj,blueAdj,true,pathArr);
        findDistance(0,0,redAdj,blueAdj,false,pathArr);
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i] = Math.min(pathArr[i][0],pathArr[i][1]);
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        
        return res;
    }
    
    public void findDistance(int node,
                             int distance,
                             Map<Integer,Set<Integer>> redAdj,
                             Map<Integer,Set<Integer>> blueAdj,
                             boolean redEdge,
                             int[][] pathArr
                            ){
        
        Set<Integer> neighbours = redEdge ? redAdj.get(node):blueAdj.get(node);
        int color = redEdge ? 0:1;
        if( distance>pathArr[node][color]){
            return;
        }
        pathArr[node][color] = Math.min(pathArr[node][color],distance);
        // System.out.println(node + " "+pathArr[node]+" "+distance);
        for(int neighbour : new ArrayList<>(neighbours)){
                neighbours.remove(neighbour);
                findDistance(neighbour,distance+1,redAdj,blueAdj,!redEdge,pathArr);
                neighbours.add(neighbour);
        }
    }
}