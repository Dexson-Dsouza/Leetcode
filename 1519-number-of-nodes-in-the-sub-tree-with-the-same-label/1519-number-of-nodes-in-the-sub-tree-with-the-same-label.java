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
    
    public Map<Character,Integer> findNodesInSubtree(
        int cur, List<List<Integer>> adj, String labels, int[] nodesInSubTree, Set<Integer> visited){
        
        Map<Character,Integer> labelCountMap=new HashMap<>();
        visited.add(cur);
        
        for(int neighbour:adj.get(cur)){
            
            if(visited.contains(neighbour)){
                continue;
            }
            
            Map<Character,Integer> childrenLabelCount = findNodesInSubtree(neighbour,adj,labels,
                                                                           nodesInSubTree,visited);
            for(Character label : childrenLabelCount.keySet()){
                int curCount = labelCountMap.getOrDefault(label,0);
                labelCountMap.put(label, curCount + childrenLabelCount.get(label));
            }
        }
        visited.remove(cur);
        char label = labels.charAt(cur);
        int labelCount = labelCountMap.getOrDefault(label,0) + 1;
        labelCountMap.put(label, labelCount);
        nodesInSubTree[cur]=labelCount;
        return labelCountMap;
    }
}