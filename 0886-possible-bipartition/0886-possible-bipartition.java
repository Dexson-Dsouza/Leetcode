class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i+1,new ArrayList<>());
        }
        for(int[] p : dislikes){
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }
        
        int[] colorArr=new int[n+1];
        Arrays.fill(colorArr,-1);
        for(int i=1;i<=n;i++){
            if(colorArr[i]==-1 && tryColor(i,0,colorArr,adj)==false){
                return false;
            }
        }
        
        return true;
    }
    
    boolean tryColor(int node, int color, int[] colorArr, Map<Integer,List<Integer>> adj){
        if(colorArr[node]!=-1){
            return colorArr[node] == color;
        }
        colorArr[node]=color;
        int nextColor = 1-color;
        boolean possibleToColor = true;
        for(int n:adj.get(node)){
            possibleToColor = possibleToColor & tryColor(n,nextColor,colorArr,adj);
        }
        return possibleToColor;
    }
}