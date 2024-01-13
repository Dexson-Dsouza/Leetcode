class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        
        for(int n:nums){
            num_set.add(n);
        }
        
        int maxLen = 0;
        
        for(int n:nums){
            
            if(!num_set.contains(n)){
                continue;
            }
            num_set.remove(n);
            int cur = n;
            int len = 1;
            int next=n+1;
            while(num_set.contains(next)){
                num_set.remove(next);
                len++;
                next++;
            }
            
            int prev=n-1;
            while(num_set.contains(prev)){
                num_set.remove(prev);
                len++;
                prev--;
            }
            
            maxLen = Math.max(maxLen,len);
            
        }
        return maxLen;
    }
}