class Solution {
    int[] parent;
    
    public int find(int p){
        if(parent[p]==-1){
            return p;
        }
        return parent[p] = find(parent[p]);
    }
    
    void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            parent[pb] = pa;
        }
    }
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        parent = new int[vals.length];
        Arrays.fill(parent,-1);
        
        for(int i=0;i<vals.length;i++){
            adj.put(i,new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if(vals[u]>=vals[v]){
                adj.get(u).add(v);
            }else{
                adj.get(v).add(u);
            }
        }
        
        Map<Integer,List<Integer>> valueNodeMap = new HashMap<>();
        for(int i=0;i<vals.length;i++){
            int val = vals[i];
            if(valueNodeMap.containsKey(val)==false){
                valueNodeMap.put(val,new ArrayList<>());
            }
            valueNodeMap.get(val).add(i);
        }
        List<Integer> sortedValueList = new ArrayList<>(valueNodeMap.keySet());
        Collections.sort(sortedValueList);
        
        int countOfPaths = vals.length;
        
        for(int val:sortedValueList){
            Map<Integer,Integer> connectedComponentCount = new HashMap<>();
            for(int node:valueNodeMap.get(val)){
                for(int neighbour:adj.get(node)){
                    union(node,neighbour);
                }
            }
            
            for(int node:valueNodeMap.get(val)){
                int parentNode = find(node);
                int currentCount = connectedComponentCount.getOrDefault(parentNode,0);
                connectedComponentCount.put(parentNode,currentCount+1);
            }
            
            for(int componentCount : connectedComponentCount.values()){
                countOfPaths += (componentCount*(componentCount-1))/2;
            }
        }
        return countOfPaths;
    }
}