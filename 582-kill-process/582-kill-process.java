class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,Set<Integer>> parentChildrenMap=new HashMap<>();
        
        for(int i=0;i<pid.size();i++){
            int parent=ppid.get(i);
            int child=pid.get(i);
            
            if(parentChildrenMap.containsKey(parent)==false){
                parentChildrenMap.put(parent,new HashSet<>());
            }
            parentChildrenMap.get(parent).add(child);
        }
        List<Integer> killedProcesses=new ArrayList<>();
        Queue<Integer> processesToKill=new LinkedList<>();
        processesToKill.add(kill);
        
        while(processesToKill.size()>0){
            int curSize=processesToKill.size();
            
            for(int i=0;i<curSize;i++){
                int currentProcess=processesToKill.poll();
                killedProcesses.add(currentProcess);
                if(parentChildrenMap.containsKey(currentProcess)==false){
                    continue;
                }
                
                for(int child:parentChildrenMap.get(currentProcess)){
                    processesToKill.add(child);
                }
            }
        }
        return killedProcesses;
    }
}