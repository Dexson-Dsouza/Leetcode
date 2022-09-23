class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        int[] maxWindow=new int[nums.length-k+1];
        int index=0;
        
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            while(dq.size()>0 && i-k>=dq.peekFirst()){
                dq.pollFirst();
            }
            
            while(dq.size()>0 && nums[dq.peekLast()]<=cur){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                maxWindow[index++]=nums[dq.peekFirst()];
            }
        }
        return maxWindow;
    }
}