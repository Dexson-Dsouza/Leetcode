class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<double[]>> adj=new HashMap<>();
        
        for(int node=0;node<n;node++){
            adj.put(node,new ArrayList<>());
        }
        
        int totalEdges=edges.length;
        
        for(int edge=0;edge<totalEdges;edge++){
            int from=edges[edge][0];
            int to=edges[edge][1];
            double prob=succProb[edge];
            adj.get(from).add(new double[]{to,prob});
            adj.get(to).add(new double[]{from,prob});
        }
        
        PriorityQueue<double[]> processingEdge=new PriorityQueue<double[]>(
            (a,b)->Double.compare(b[1],a[1]));
        
        double[] probs=new double[n];
        processingEdge.add(new double[]{start,1});
        
        while(processingEdge.size()>0){
            double[] top=processingEdge.poll();
            int node=(int)(top[0]);
            double prob=top[1];
            if(node==end){
                return prob;
            }
            
            for(double[] adjecentEdges:adj.get(node)){
                int neighbour= (int)(adjecentEdges[0]);
                double neighbourProb= adjecentEdges[1];
                
                if(neighbourProb*prob> probs[neighbour]){
                    probs[neighbour]=neighbourProb*prob;
                    processingEdge.add(new double[]{neighbour,neighbourProb*prob});
                }
            }
            
        }
        return 0;
    }
}