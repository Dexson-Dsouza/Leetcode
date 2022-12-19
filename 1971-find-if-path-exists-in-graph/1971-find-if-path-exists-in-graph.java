class DisjointSetUnion{
    private int[] parent;
    private int[] rank;
    private int N;
    
    public DisjointSetUnion(int n){
        this.N = n;
        this.parent = new int[this.N];
        this.rank = new int[this.N];
        for(int i = 0; i < this.N; i++){
            this.parent[i] = -1;
            this.rank[i] = 1;
        }
    }
    
    public boolean areConnected(int u, int v){
        return find(u) == find(v);
    }
    
    public void union(int u, int v){
        if(u != v){
            int a = find(u);
            int b = find(v);
            if(a != b){
                if(rank[a] > rank[b]){
                    parent[b] = a;
                    rank[a] ++;
                }else{
                    parent[a] = b;
                    rank[b] ++;
                }
            }
        }
    }
    
    private int find(int u){
        if(parent[u]==-1){
            return u;
        }
        return parent[u]=find(parent[u]);
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        DisjointSetUnion set = new DisjointSetUnion(n);
        for(int[] edge : edges){
            set.union(edge[0], edge[1]);
        }
        
        return set.areConnected(start, end);
    }
}
