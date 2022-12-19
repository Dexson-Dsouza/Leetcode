class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer,Set<Integer>> adj=new HashMap<>();
        
        for(int i=0;i<n;i++){
            adj.put(i+1,new HashSet<>());
        }
        
        int[] degree=new int[n+1];
        for(List<Integer> edge:edges){
            int node1=edge.get(0);
            int node2=edge.get(1);
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
            degree[node1]++;
            degree[node2]++;
        }
        
        Set<Integer> oddNodes=new HashSet<>();
        
        for(int i=1;i<=n;i++){
            if(degree[i]%2==1){
                oddNodes.add(i);
            }
        }
        // System.out.println(oddNodes);
        if(oddNodes.size()>4){
            return false;
        }
        if(oddNodes.size()%2==1){
            return false;
        }
        
        if(oddNodes.size()==2){
            List<Integer> oddNodeList = new ArrayList<>(oddNodes);
            int n1=oddNodeList.get(0);
            int n2=oddNodeList.get(1);
            for(int i=1;i<=n;i++){
                if(adj.get(i).contains(n1)==false && adj.get(i).contains(n2)==false){
                    return true;
                }
            }
            return false;
        }else{
            return addEdge(adj,oddNodes,degree);
        }
    }
    
    public boolean addEdge(Map<Integer,Set<Integer>> adj, Set<Integer> oddNodes, int[] indegree){
        // System.out.println(oddNodes);
        if(oddNodes.size()==0){
            return true;
        }
        
        for(int node:new ArrayList<>(oddNodes)){
            if(indegree[node]%2==0){
                continue;
            }
            indegree[node]++;
            oddNodes.remove(node);
            for(int nextNode:new ArrayList<>(oddNodes)){
                if(node==nextNode){
                    continue;
                }
                if(adj.get(node).contains(nextNode)){
                    continue;
                }
                
                indegree[nextNode]++;
                oddNodes.remove(nextNode);
                if(addEdge(adj,oddNodes,indegree)){
                    return true;
                }
                indegree[nextNode]--;
                oddNodes.add(nextNode);
                
            }
            oddNodes.add(node);
            indegree[node]--;
        }
        
        return false;
    }
}