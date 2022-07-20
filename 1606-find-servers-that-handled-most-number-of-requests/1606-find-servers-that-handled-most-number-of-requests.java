class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> servers=new TreeSet<>();
        
        for(int i=0;i<k;i++){
            servers.add(i);
        }
        
        
        int totalRequest=arrival.length;
        int[] requestsHandledCount=new int[k];
        
        int maxRequestsHandledCount=0;
        
        PriorityQueue<int[]> serverEndTimeQueue=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int req=0;req<totalRequest;req++){
            int serverIndex=req%k;
            
            int curTime=arrival[req];
            int endTime=curTime+load[req];
            
            while(serverEndTimeQueue.size()>0 && serverEndTimeQueue.peek()[0]<=curTime){
                servers.add(serverEndTimeQueue.peek()[1]);
                serverEndTimeQueue.poll();
            }
            
            Integer assignedServer = servers.ceiling(serverIndex);
            if(assignedServer==null){
                assignedServer = servers.ceiling(0);
            }
            if(assignedServer!=null){
                servers.remove(assignedServer);
                requestsHandledCount[assignedServer]++;
                serverEndTimeQueue.add(new int[]{endTime,assignedServer});
                maxRequestsHandledCount=Math.max(maxRequestsHandledCount,requestsHandledCount[assignedServer]);
            }
            
        }
        List<Integer> busiestServerList=new ArrayList<>();
        for(int server=0;server<k;server++){
            if(requestsHandledCount[server]==maxRequestsHandledCount){
                busiestServerList.add(server);
            }
        }
        return busiestServerList;
    }
}