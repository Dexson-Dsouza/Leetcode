class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxSoFar=new LinkedList<>();
        Deque<Integer> minSoFar=new LinkedList<>();
    
        int maxLen=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            int curNum = nums[i];
            while(maxSoFar.size()>0 && nums[maxSoFar.peekLast()]<curNum){
                maxSoFar.pollLast();
            }
            
            while(minSoFar.size()>0 && nums[minSoFar.peekLast()]>curNum){
                minSoFar.pollLast();
            }
            
            maxSoFar.addLast(i);
            minSoFar.addLast(i);
            
            while(maxSoFar.size()>0 && minSoFar.size()>0){
                int smallestIndex = minSoFar.peekFirst();
                int largestIndex = maxSoFar.peekFirst();
                if(nums[largestIndex]-nums[smallestIndex]>limit){
                    if(smallestIndex==start){
                        minSoFar.pollFirst();
                    }
                    if(largestIndex==start){
                        maxSoFar.pollFirst();
                    }
                    start++;
                }else{
                    break;
                }
            }
            if(maxSoFar.size()>0 && minSoFar.size()>0){
                maxLen=Math.max(maxLen,i-start+1);
            }
        }
        return maxLen;
    }
}