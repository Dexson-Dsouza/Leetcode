class Solution {
    int[] parent;
    
    int find(int a){
        if(parent[a]==a){
            return a;
        }
        return parent[a]=find(parent[a]);
    }
    
    void addEdge(int a, int b){
        int pa=find(a);
        int pb=find(b);
        parent[pb]=pa;
    }
    
    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int e[]:edges){
            addEdge(e[0],e[1]);
        }
        
        long count=0;
        Map<Integer,HashSet<Integer>> m=new HashMap<>();
        for(int i=0;i<n;i++){
            int p=find(i);
            if(m.containsKey(p)==false){
                m.put(p,new HashSet<Integer>());
            }
            m.get(p).add(i);
        }
        
        for(int i=0;i<n;i++){
            int p=find(i);
            int connectedNodes=m.get(p).size();
            count += (n-connectedNodes);   
        }
        
        
        return count/2;
    }
}