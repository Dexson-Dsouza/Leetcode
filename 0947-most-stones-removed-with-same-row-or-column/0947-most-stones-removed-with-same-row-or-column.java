class DisjointSet{
    int[] parent;
    DisjointSet(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=-1;
        }
    }
    
    void add(int a, int b){
        int parentA =find(a);
        int parentB =find(b);
        if(parentA!=parentB){
            parent[parentB]=parentA;
        }
    }
    
    int find(int a){
        if(parent[a]==-1){
            return a;
        }
        return parent[a]=find(parent[a]);
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int totalStones=stones.length;
        DisjointSet stoneGroups=new DisjointSet(totalStones);
        
        for(int index1=0;index1<totalStones;index1++){
            for(int index2=index1+1;index2<totalStones;index2++){
                int x1=stones[index1][0];
                int y1=stones[index1][1];
                int x2=stones[index2][0];
                int y2=stones[index2][1];
                if(x1==x2 || y1==y2){
                    stoneGroups.add(index1,index2);
                }
            }
        }
        
        Map<Integer,Integer> groupMemberCount=new HashMap<>();
        for(int index=0;index<totalStones;index++){
            int parent=stoneGroups.find(index);
            groupMemberCount.put(parent,groupMemberCount.getOrDefault(parent,0)+1);
        }
        
        int count=0;
        for(int key:groupMemberCount.keySet()){
            count+=groupMemberCount.get(key)-1;
        }
        return count;
        
    }
}