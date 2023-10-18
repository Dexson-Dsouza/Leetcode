class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indeg = new int[n+1];
        
        Map<Integer,List<Integer>> adj=new HashMap<>();
        
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        
        for(int[] rel:relations){
            indeg[rel[1]]++;
            adj.get(rel[0]).add(rel[1]);
        }
        
        PriorityQueue<int[]> courseInQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                courseInQueue.add(new int[]{i,time[i-1]});
            }
        }
        
        int maxTime = 0;
        
        while(courseInQueue.size()!=0){
            
            int[] front = courseInQueue.poll();
            int course=front[0];
            int curTime=front[1];
            maxTime = Math.max(maxTime,curTime);
            
            
            for(int next:adj.get(course)){
                indeg[next]--;
                if(indeg[next]==0){
                    courseInQueue.add(new int[]{next,curTime + time[next-1] });
                }
            }
        }
        
        return maxTime;
    }
}