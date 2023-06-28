class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        List<List<double[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            adj.get(from).add(new double[]{to,prob});
            adj.get(to).add(new double[]{from,prob});
        }
        
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        
        Set<Integer> visited=new HashSet<>();
        pq.add(new double[]{1,start});
        
        while(pq.size()>0){
            double prob = pq.peek()[0];
            int node = (int)pq.peek()[1];
            pq.poll();
            visited.add(node);
            // System.out.println(node+" "+prob);
            if(node==end){
                return prob;
            }
            
            for(double[] neighbourProbArr : adj.get((int)node)){
                int neighbour=(int)neighbourProbArr[0];
                double curProb = neighbourProbArr[1];
                if(visited.contains(neighbour)==false){
                    
                    pq.add(new double[]{curProb*prob,neighbour});
                    // System.out.println(neighbour+"---------"+curProb*prob);
                }
            }
        }
        
        return 0;
    }
}