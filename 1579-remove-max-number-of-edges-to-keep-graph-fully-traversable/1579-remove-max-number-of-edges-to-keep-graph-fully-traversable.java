class DSU{
    int[] parent;
    DSU(int n){
        parent = new int[n];
        Arrays.fill(parent,-1);
    }
    
    int find(int a){
        if(parent[a]==-1){
            return a;
        }
        parent[a]= find(parent[a]);
        return parent[a];
    }
    
    void union(int a, int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb){
            parent[pa]=pb;
        }
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceSet = new DSU(n+1);
        DSU bobSet = new DSU(n+1);
        int count = 0;
        for(int[] edge:edges){
            int type=edge[0];
            int from=edge[1];
            int to=edge[2];
            
            if(type==3){
                int parentFromAlice = aliceSet.find(from);
                int parentToAlice = aliceSet.find(to);
                int parentFromBob = bobSet.find(from);
                int parentToBob = bobSet.find(to);
                if(parentFromAlice!= parentToAlice ||parentFromBob!=parentToBob ){
                    aliceSet.union(from,to);
                    bobSet.union(from,to);    
                }else{
                    count++;
                }
            }
        }
        for(int[] edge:edges){
            int type=edge[0];
            int from=edge[1];
            int to=edge[2];
            if(type==1){
                int parentFrom = aliceSet.find(from);
                int parentTo = aliceSet.find(to);
                if(parentFrom != parentTo){
                    aliceSet.union(from,to);
                }else{
                    count++;
                }
            }
            if(type==2){
                int parentFrom = bobSet.find(from);
                int parentTo = bobSet.find(to);
                if(parentFrom != parentTo){
                    bobSet.union(from,to);
                }else{
                    count++;
                }
            }
        }
        
        boolean isTraversible = true;
        int parentNodeAlice = aliceSet.find(1);
        int parentNodeBob = bobSet.find(1);
        // System.out.println(Arrays.toString(aliceSet.parent)+" "+Arrays.toString(bobSet.parent));
        for(int node = 2;node<=n && isTraversible;node++){
            int parentCurAlice = aliceSet.find(node);
            if(parentCurAlice!=parentNodeAlice){
                isTraversible=false;
            }
            int parentCurBob = bobSet.find(node);
            if(parentCurBob!=parentNodeBob){
                isTraversible=false;
            }
            
            // System.out.println(node+" "+parentNodeAlice+" "+parentCurAlice+" "+parentNodeBob+" "+parentCurBob);
        }
        return isTraversible?count:-1;
    }
}