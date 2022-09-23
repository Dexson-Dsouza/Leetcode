class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        List<Integer> maxWindowList=new ArrayList<>();
        for(int i=0;i<k-1;i++){
            int cur=nums[i];
            while(dq.size()>0 && i-k>=dq.peekFirst()){
                dq.pollFirst();
            }
            
            while(dq.size()>0 && nums[dq.peekLast()]<=cur){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        
        int index=0;
        
        for(int i=k-1;i<nums.length;i++){
            int cur=nums[i];
            while(dq.size()>0 && i-k>=dq.peekFirst()){
                dq.pollFirst();
            }
            
            while(dq.size()>0 && nums[dq.peekLast()]<=cur){
                dq.pollLast();
            }
            dq.addLast(i);
            maxWindowList.add(nums[dq.peekFirst()]);
        }
        int[] result=new int[maxWindowList.size()];
        for(int i=0;i<maxWindowList.size();i++){
            result[i]=maxWindowList.get(i);
        }
        
        return result;
    }
}