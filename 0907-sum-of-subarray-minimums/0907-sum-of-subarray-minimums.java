class Solution {
    public int sumSubarrayMins(int[] arr) {
        int inputSize=arr.length;
        int[] left=new int[inputSize];
        int[] right=new int[inputSize];
        Stack<Integer> st=new Stack<>();
        int curIndex=0;
        while(curIndex<inputSize){
            int curNum = arr[curIndex];
            while(st.size()>0 && arr[st.peek()]>curNum){
                st.pop();
            }
            left[curIndex]=st.size()==0?curIndex+1:curIndex-st.peek();
            st.push(curIndex);
            curIndex++;
        }
        st=new Stack<>();
        curIndex=inputSize-1;
        while(curIndex>=0){
            int curNum = arr[curIndex];
            while(st.size()>0 && arr[st.peek()]>=curNum){
                st.pop();
            }
            right[curIndex]=st.size()==0?inputSize-curIndex:st.peek()-curIndex;
            st.push(curIndex);
            curIndex--;
        }
        
        long res=0;
        int mod=(int)(Math.pow(10,9)+7);
        for(int i=0;i<inputSize;i++){
            // System.out.println(left[i]+" "+right[i]+" "+arr[i]);
            res = (res + ((long)(arr[i])*(left[i]*right[i])))%mod;
        }
        return (int)(res);
        
    }
}