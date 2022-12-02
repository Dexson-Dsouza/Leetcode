class Solution {
    public int dfs(int cur, boolean[] visited, List<List<Integer>> graph){
        visited[cur]=true;
        int len = 0;
        for(int neighbour:graph.get(cur)){
            len = Math.max(len, dfs(neighbour,visited,graph));
        }
        return len + 1;
    }
    
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; ++i) {
            int j = favorite[i];
            if(i != favorite[j]){
                graph.get(j).add(i);
            }
        }
        
        int result1 = 0; // acyclic chains
        boolean[] visited1 = new boolean[n];
        for(int i = 0; i < n; ++i) {
            int j = favorite[i];
            if(i == favorite[j]){
                int length1 = dfs(i,visited1,graph);
                // System.out.println(i+" "+ length1+" "+j+" "+length2);
                result1 += length1;
            }
        }
    
        int result2 = 0; // find largest cycle
    
        for(int i = 0; i < n; ++i) {
            int start = i;
            int length = 0;
            int j = start;
            for(; visited1[j] == false; j = favorite[j]) {
                visited1[j] = true;
                ++length;
            }

            while(start!=j){
                length--;
                start = favorite[start];
            }
            
            // System.out.println(i +" "+length);
            result2 = Math.max(result2, length);    
            
        }
        return Math.max(result1, result2);
    }
}