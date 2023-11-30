class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> taskCountMap = new HashMap<>();
        for(int task:tasks){
            taskCountMap.put(task,taskCountMap.getOrDefault(task,0)+1);
        }
        
        int roundCount = 0;
        for(int task:taskCountMap.keySet()){
            int taskCount = taskCountMap.get(task);
            if(taskCount==1){
                roundCount=-1;
                break;
            }
            if(taskCount%3==0){
                roundCount += taskCount/3;
            }else{
                roundCount += taskCount/3;
                roundCount++;
            }
        }
        return roundCount;
    }
}