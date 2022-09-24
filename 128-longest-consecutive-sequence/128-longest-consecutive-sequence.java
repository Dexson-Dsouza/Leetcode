class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        
        int maxLen=0;
        
        for(int n:nums){
            numSet.add(n);
        }
        
        for(int n:new ArrayList<>(numSet)){
            if(numSet.contains(n)==false){
                continue;
            }
            int curLen=1;
            numSet.remove(n);
            int prev=n-1;
            int next=n+1;
            
            while(numSet.contains(prev)){
                numSet.remove(prev);
                prev--;
                curLen++;
            }
            while(numSet.contains(next)){
                numSet.remove(next);
                next++;
                curLen++;
            }
            maxLen=Math.max(curLen,maxLen);
        }
        return maxLen;
    }
}