class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ=new LinkedList<>();
        Deque<Integer> minQ=new LinkedList<>();
    
        int maxLen=0;
        int prev=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            
            while(maxQ.size()>0 && n>nums[maxQ.peekLast()]){
                maxQ.pollLast();
            }
            maxQ.add(i);
            
            
            while(minQ.size()>0 && n<nums[minQ.peekLast()]){
                minQ.pollLast();
            }
            minQ.add(i);
            
            while(maxQ.size()>0 && minQ.size()>0 && (nums[maxQ.peekFirst()]-nums[minQ.peekFirst()])>limit){
                if(maxQ.peekFirst()==prev){
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst()==prev){
                    minQ.pollFirst();
                }
                prev++;
            } 
            
            maxLen = Math.max(maxLen,i-prev+1);
        }
        return maxLen;
    }
}