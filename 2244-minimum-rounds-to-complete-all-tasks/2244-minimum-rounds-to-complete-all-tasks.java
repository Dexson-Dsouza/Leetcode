class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> taskMap = new HashMap<>();
        
        for(int task:tasks){
            taskMap.put(task,taskMap.getOrDefault(task,0)+1);
        }
        
        int roundCount = 0;
        
        for(int task:taskMap.keySet()){
            int countOfTask = taskMap.get(task);
            
            if(countOfTask==1){
                return -1;
            }
            
            roundCount += countOfTask/3;
            countOfTask = countOfTask%3;
            if(countOfTask==1){
                countOfTask += 3;
                roundCount--;
            }
            roundCount += countOfTask/2;
        }
        
        return roundCount;
    }
}