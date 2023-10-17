class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        
        Map<Integer,List<Integer>> adj=new HashMap<>();
        
        boolean[] isParent=new boolean[n]; 
        Arrays.fill(isParent,true);
        
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
            if(leftChild[i]!=-1){
                adj.get(i).add(leftChild[i]);
                isParent[leftChild[i]]=false;
            }
            if(rightChild[i]!=-1){
                adj.get(i).add(rightChild[i]);
                isParent[rightChild[i]]=false;
            }
        }
        int parent= -1;
        
        for(int i=0;i<n;i++){
            if(isParent[i]){
                if(parent!=-1){
                    return false;
                }
                parent = i;
            }
        }
        if(parent == -1){
            return false;
        }
        int visitedNodeCount = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(parent);
        Set<Integer> visited=new HashSet<>();
        while(q.size()>0){
            int cur=q.poll();
            if(visited.contains(cur)){
                return false;
            }
            visitedNodeCount++;
            visited.add(cur);
            for(int neighbour:adj.get(cur)){
                q.add(neighbour);
            }
        }
        
        return visitedNodeCount == n;
        
        
    }
}