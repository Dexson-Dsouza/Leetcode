class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2){
            ArrayList<Integer> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                res.add(i);
            }
            return res;
        }
        
        List<Set<Integer>> adjList=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new HashSet<>());
        
        for(int[]edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves=new ArrayList<>();
        for(int i=0;i<adjList.size();i++){
            if(adjList.get(i).size()==1){
                leaves.add(i);
            }
        }
        
        while(true){
            List<Integer> newLeaves=new ArrayList<>();
            for(int node:leaves){
                Set<Integer> connected=adjList.get(node);
                for(int i: connected){
                    adjList.get(i).remove(node);
                    if(adjList.get(i).size()==1)
                        newLeaves.add(i);
                }
                
            }
            if(newLeaves.size()==0){
                break;
            }
            leaves=newLeaves;
        }
        
        return leaves;
    }
}