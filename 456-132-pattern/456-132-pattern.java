class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        int[] smallest=new int[len];
        int currentSmallest=Integer.MAX_VALUE;
        
        for(int index=0;index<len;index++){
            currentSmallest=Math.min(currentSmallest,nums[index]);
            smallest[index]=currentSmallest;
        }
        
        Stack<Integer> st=new Stack<>();
        
        for(int index=len-1;index>=1;index--){
            if(nums[index]<=smallest[index]){
                continue;
            }
            int second=nums[index];
            // while(st.size()>0 && st.peek()>second){
            //     st.pop();
            // }
            while(st.size()>0 && st.peek()<=smallest[index]){
                st.pop();
            }
            
            
            if(st.size()>0 && st.peek()<second){
                return true;
            }
            st.push(second);
        }
        return false;
    }
}