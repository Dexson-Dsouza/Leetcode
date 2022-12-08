class Solution {
    int[] parent;
    int totalComponentCount;
    
    int find(int a){
        if(parent[a]==-1){
            return a;
        }
        return parent[a]=find(parent[a]);
    }
    
    void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb){
            parent[pa]=pb;
            totalComponentCount--;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        parent=new int[n];
        Arrays.fill(parent,-1);
        totalComponentCount = n;
        
        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }
        
        return totalComponentCount;
    }
}