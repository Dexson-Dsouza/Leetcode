class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> adj=new HashMap<>();
        int totalEquations=equations.size();
        
        for(int eq=0;eq<totalEquations;eq++){
            String var1=equations.get(eq).get(0);
            String var2=equations.get(eq).get(1);
            double value=values[eq];
            if(adj.containsKey(var1)==false){
                adj.put(var1,new HashMap<>());
            }
            if(adj.containsKey(var2)==false){
                adj.put(var2,new HashMap<>());
            }
            adj.get(var1).put(var2,value);
            adj.get(var2).put(var1,1/value);
        }
        int totalQueries=queries.size();
        double[] queriesResult=new double[totalQueries];
        
        for(int query=0;query<totalQueries;query++){
            String var1=queries.get(query).get(0);
            String var2=queries.get(query).get(1);
            double value=solveEquation(var1,var2,adj);
            queriesResult[query]=value;
        }
        return queriesResult;
    }
    
    class variableValuePair{
        String var;
        double value;
        variableValuePair(String var, double value){
            this.var=var;
            this.value=value;
        }
    }
    
    double solveEquation(String source,String dest, Map<String,Map<String,Double>> adj){
        if(adj.containsKey(source)==false){
            return -1;
        }
        if(source.equals(dest)){
            return 1;
        }
        
        Queue<variableValuePair> curVariables=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        curVariables.add(new variableValuePair(source,1));
        visited.add(source);
        
        while(curVariables.size()>0){
            int curSize=curVariables.size();
            while(curSize>0){
                curSize--;
                String curVar=curVariables.peek().var;
                Double value=curVariables.peek().value;
                curVariables.poll();
                for(String neighbour:adj.get(curVar).keySet()){
                    Double nextValue=adj.get(curVar).get(neighbour) * value;
                    if(neighbour.equals(dest)){
                        return nextValue;
                    }
                    if(visited.contains(neighbour)==false){
                        visited.add(neighbour);
                        curVariables.add(new variableValuePair(neighbour,nextValue));
                    }
                }
            }
        }
        return -1;
    }
}