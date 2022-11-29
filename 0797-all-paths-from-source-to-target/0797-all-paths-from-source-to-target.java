class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findAllPath(0,graph.length-1,graph,path,paths);
        return paths;
    }
    
    public void findAllPath(int curNode, int endNode, int[][] graph, List<Integer> path,
                            List<List<Integer>> paths){
        path.add(curNode);    
        if(curNode==endNode){
            paths.add(new ArrayList(path));
            path.remove(path.size()-1);  
            return;
        }
        
        for(int neighbour : graph[curNode]){
            findAllPath(neighbour,endNode,graph,path,paths);
        }
        path.remove(path.size()-1);    
    }
}