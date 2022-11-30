class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<String>> adj=new HashMap<>();
        
        for(int i=0;i<equations.size();i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];
            if(adj.containsKey(from)==false){
                adj.put(from,new ArrayList<>());
            }
            if(adj.containsKey(to)==false){
                adj.put(to,new ArrayList<>());
            }
            adj.get(from).add(to+","+weight);
            adj.get(to).add(from+","+(1/weight));
        }
        
        double[] result = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            Set<String> visited=new HashSet<>();
            result[i] = solve(from,to,1,adj,visited);
        }
        return result;
    }
    
    public double solve(String source, String dest, double curVal, Map<String,List<String>> adj, Set<String> visited){
        if(adj.containsKey(source)==false){
            return -1;
        }
        if(source.equals(dest)){
            return curVal;
        }
        
        visited.add(source);
        for(String neighbourWeightStr : adj.get(source)){
            
            String[] neighbourWeightArr = neighbourWeightStr.split(",");
            String neighbour = neighbourWeightArr[0];
            double weight = Double.parseDouble(neighbourWeightArr[1]);
            
            if(visited.contains(neighbour)){
                continue;
            }
            
            double wieghtToReachDest = solve(neighbour,dest,curVal*weight,adj,visited);
            // System.out.println(source+" "+neighbour+" "+wieghtToReachDest);
            if(wieghtToReachDest!=-1){
                return wieghtToReachDest;
            }
            
        }
        
        visited.remove(source);
        return -1;
    }
}