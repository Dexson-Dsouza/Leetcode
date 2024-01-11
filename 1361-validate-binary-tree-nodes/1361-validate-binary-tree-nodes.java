class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg=new int[n];
        Arrays.fill(indeg,0);
        
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1){
                indeg[leftChild[i]]++;
            }
            if(rightChild[i]!=-1){
                indeg[rightChild[i]]++;
            }
        }
        
        
        Queue<Integer> nodes = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                nodes.add(i);
            }
            if(indeg[i]>1){
                return false;
            }
        }
        
        if(nodes.size()!=1){
            return false;
        }
        
        int visited_node_count = 0;
        
        while(nodes.size()>0){
            int node = nodes.poll();
            visited_node_count++;
            int left_child = leftChild[node];
            int right_child = rightChild[node];
            
            if(left_child!=-1){
                indeg[left_child]--;
                if(indeg[left_child]==0){
                    nodes.add(left_child);
                }
            }
            if(right_child!=-1){
                indeg[right_child]--;
                if(indeg[right_child]==0){
                    nodes.add(right_child);
                }
            }
            
        }
        return visited_node_count==n;
    }
}