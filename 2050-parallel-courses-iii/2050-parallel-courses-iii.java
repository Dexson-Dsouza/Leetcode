class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indeg = new int[n+1];
        
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int[] maxTimeArr = new int[n+1];
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        
        for(int[] rel:relations){
            indeg[rel[1]]++;
            adj.get(rel[0]).add(rel[1]);
        }
        
        Queue<int[]> courseInQueue = new LinkedList<>();
        
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                courseInQueue.add(new int[]{i,time[i-1]});
                maxTimeArr[i] = time[i-1];
            }
        }
        
        int maxTime = 0;
        
        while(courseInQueue.size()!=0){
            
            int[] front = courseInQueue.poll();
            int course=front[0];
            int curTime=front[1];
            
            
            
            for(int next:adj.get(course)){
                indeg[next]--;
                maxTimeArr[next] = Math.max(maxTimeArr[next],maxTimeArr[course]+time[next-1]);
                if(indeg[next]==0){
                    courseInQueue.add(new int[]{next,curTime + time[next-1] });
                }
            }
        }
        
        for(int t:maxTimeArr){
            maxTime = Math.max(maxTime,t);
        }
        
        return maxTime;
    }
}