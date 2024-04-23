class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null|| k<=0)
            return new int[0];
        int[]res=new int[nums.length-k+1];
        Deque<Integer>dq=new ArrayDeque<>();
        int idx=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && i-k>=dq.peekFirst())
                dq.pollFirst();
            
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
                dq.pollLast();
            
            dq.addLast(i);
            
            if(i>=k-1){
                res[idx]=nums[dq.peekFirst()];
                idx++;
            }
        }
        
        return res;
    }
}