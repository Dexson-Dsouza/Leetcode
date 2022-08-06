class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<int[]> st=new Stack();
        
        for(int n:arr){
            int start=n;
            int end=n;
            
            while(st.size()>0 && st.peek()[1]>start){
                start=Math.min(start,st.peek()[0]);
                end=Math.max(end,st.peek()[1]);
                st.pop();
            }
            st.push(new int[]{start,end});
        }
        return st.size();
    }
}