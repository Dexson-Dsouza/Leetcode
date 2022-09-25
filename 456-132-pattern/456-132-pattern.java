class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        int[] smallest=new int[len];
        int currentSmallest=Integer.MAX_VALUE;
        
        for(int index=0;index<len;index++){
            currentSmallest=Math.min(currentSmallest,nums[index]);
            smallest[index]=currentSmallest;
        }
        
        PriorityQueue<Integer> st=new PriorityQueue<>();
        
        for(int index=len-1;index>=1;index--){
            int second=nums[index];
            while(st.size()>0 && st.peek()<=smallest[index-1]){
                st.poll();
            }
            
            if(st.size()>0 && st.peek()<second){
                return true;
            }
            st.add(second);
            
        }
        return false;
    }
}