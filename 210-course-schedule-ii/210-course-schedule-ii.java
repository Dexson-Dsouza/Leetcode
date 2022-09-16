class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree=new int[numCourses];
        
        for(int [] pre:prerequisites){
            int from=pre[0];
            int to=pre[1];
            
            adj.get(from).add(to);
            adj.get(to).add(from);
            indegree[from]++;
        }
        
        Queue<Integer> coursesToComplete=new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                coursesToComplete.add(i);   
            }
        }
        
        List<Integer> courseOrder=new ArrayList<>();
        while(coursesToComplete.size()>0){
            int curSize=coursesToComplete.size();
            while(curSize>0){
                curSize--;
                int curCourse=coursesToComplete.poll();
                courseOrder.add(curCourse);
                for(int neighbour:adj.get(curCourse)){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        coursesToComplete.add(neighbour);
                    }
                }
            }
        }
        
        if(courseOrder.size()!=numCourses){
            return new int[0];
        }
        int[] courseOrderArr=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            courseOrderArr[i]=courseOrder.get(i);
        }
        return courseOrderArr;
    }
}