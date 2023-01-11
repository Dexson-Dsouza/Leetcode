class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited=new HashSet<>();
        return findTime(0,adj,hasApple,visited);
    }
    
    public int findTime(int cur, List<List<Integer>> adj, List<Boolean> hasApple,Set<Integer> visited){
        int time = 0;
        visited.add(cur);
        for(int n:adj.get(cur)){
            if(visited.contains(n)==true){
                continue;
            }
            time += findTime(n,adj,hasApple,visited);
        }
        if(cur!=0 && (hasApple.get(cur)==true || time>0)){
            time+=2;
        }
        return time;
    }
}