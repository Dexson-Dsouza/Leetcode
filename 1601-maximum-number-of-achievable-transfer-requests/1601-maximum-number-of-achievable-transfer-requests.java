class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] in_deg = new int[n];
        
        return find_max_req(0,requests,in_deg,0);
    }
    
    int find_max_req(int i, int[][] requests, int[] in_deg, int count){
        
        if(i==requests.length){
            for(int deg:in_deg){
                if(deg!=0){
                    return 0;
                }
            }
            return count;
        }
        
        // ignore this request
        int count_ignore=find_max_req(i+1,requests,in_deg,count);
        
        // consider this request 
        int from = requests[i][0];
        int to = requests[i][1];
        in_deg[from]--;
        in_deg[to]++;
        int count_consider=find_max_req(i+1,requests,in_deg,count+1);
        in_deg[from]++;
        in_deg[to]--;
        
        return Math.max(count_ignore,count_consider);
    }
}