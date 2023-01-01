class Solution {
    public int[] getOrder(int[][] tasks) {
        int curTime=0;
        int numOfTasks=tasks.length;
        int[] finishedOrder=new int[numOfTasks];
        int finishIndex=0;
        int[][] taskWithId=new int[numOfTasks][3];
        for(int task=0;task<numOfTasks;task++){
            taskWithId[task][0]=tasks[task][0];
            taskWithId[task][1]=tasks[task][1];
            taskWithId[task][2]=task;
        }
        Arrays.sort(taskWithId,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
        int task=0;

        while(pq.size()>0 || task<numOfTasks){
            
            while(task<numOfTasks && taskWithId[task][0]<=curTime){
                pq.add(taskWithId[task++]);
            }
            if(pq.size()==0){
                curTime=taskWithId[task][0];
                continue;
            }
            int[] smallest=pq.poll();
            finishedOrder[finishIndex++]=smallest[2];
            curTime+=smallest[1];
        }
        
        return finishedOrder;
    }
}