class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] visited=new int[n];
        
        return checkPath(source,destination,adj,visited);
    }
    
    boolean checkPath(int s, int d, List<List<Integer>> adj, int[] visited){
        
        if(visited[s]!=0){
            return visited[s]==1;
        }
        if(adj.get(s).size()==0){
            return s==d;
        }
        visited[s]=-1;
        for(int n:adj.get(s)){
            
            if(checkPath(n,d,adj,visited)==false){
                return false;
            }
        }
        visited[s]=1;
        return true;
    }
}