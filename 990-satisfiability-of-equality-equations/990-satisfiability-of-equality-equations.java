class Solution {
    
    static class DSU{
        int[] parent;
        int[] rank;
        
        DSU(){
            parent=new int[26];
            rank=new int[26];
            Arrays.fill(parent,-1);
        }
        
        int find(int node){
            if(parent[node]==-1){
                return node;
            }
            return parent[node]=find(parent[node]);
        }
        
        void union(int a, int b){
            int pa=find(a);
            int pb=find(b);
            if(pa!=pb){
                if(rank[pa]>=rank[pb]){
                    parent[pb]=pa;
                }else{
                    parent[pa]=pb;
                }
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        List<String> unequalEquations=new ArrayList<>();
        DSU dset=new DSU();
        
        for(String eq:equations){
            if(eq.charAt(1)=='='){
                int childA=eq.charAt(0)-'a';
                int childB=eq.charAt(3)-'a';
                dset.union(childA,childB);
                
            }else{
                unequalEquations.add(eq);
            }
        }
        
        for(String eq:unequalEquations){
            int childA=eq.charAt(0)-'a';
            int childB=eq.charAt(3)-'a';
            
            int parentA=dset.find(childA);
            int parentB=dset.find(childB);
            if(parentA==parentB){
                return false;
            }
        }
        
        return true;
    }
}