class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] nodesInSubTree=new int[n];
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> visited=new HashSet<>();
        findNodesInSubtree(0,adj,labels,nodesInSubTree,visited);
        return nodesInSubTree;
    }
    
    int[] findNodesInSubtree(int cur, List<List<Integer>> adj, String labels, int[] nodesInSubTree, Set<Integer> visited){
        visited.add(cur);
        int[] count=new int[26];
        
        int labelIndex = labels.charAt(cur)-'a';
        count[labelIndex]++;
        
        for(int neighbour:adj.get(cur)){
            
            if(visited.contains(neighbour)){
                continue;
            }
            
            int[] neighbourCount=findNodesInSubtree(neighbour,adj,labels,nodesInSubTree,visited);
            for(int i=0;i<26;i++){
                count[i] += neighbourCount[i];
            }
        }
        visited.remove(cur);
        nodesInSubTree[cur]=count[labelIndex];
        return count;
    }
}