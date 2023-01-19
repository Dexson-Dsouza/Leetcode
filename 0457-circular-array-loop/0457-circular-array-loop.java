class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        int[] visited = new int[len];
        
        for(int i = 0; i < len; i++){
            if(visited[i]==0 && traverse(nums,visited,i,i)==true){
                return true;
            }
        }
        return false;
    }
    
    boolean traverse(int[] nums, int[] visited, int cur, int par){
        if(visited[cur]==2){
            return false;
        }
        
        if(visited[cur]==1){
            return true;
        }
        
        visited[cur] = 1;
        
        int next = (cur + nums[cur])%nums.length;
        if(next<0){
            next += nums.length;
        }
        if(next == cur){
            visited[cur]=2;
            return false;
        }
        
        if(nums[next]*nums[par]<0){
            visited[cur] = 2;
            return false;
        }
        
        if(traverse(nums,visited,next,par)==true){
            return true;
        }
        visited[cur]=2;
        return false;
    }
}