class Solution {
    public int sumSubarrayMins(int[] arr) {
        int inputSize=arr.length;
        int[] left=new int[inputSize];
        int[] right=new int[inputSize];
        Stack<Integer> st=new Stack<>();
        int curIndex=0;
        while(curIndex<inputSize){
            int curNum = arr[curIndex];
            int countOfBiggerNums=1;
            while(st.size()>0 && arr[st.peek()]>curNum){
                countOfBiggerNums+=left[st.peek()];
                st.pop();
            }
            left[curIndex]=countOfBiggerNums;
            st.push(curIndex);
            curIndex++;
        }
        st=new Stack<>();
        curIndex=inputSize-1;
        while(curIndex>=0){
            int curNum = arr[curIndex];
            int countOfBiggerNums=1;
            while(st.size()>0 && arr[st.peek()]>=curNum){
                countOfBiggerNums+=right[st.peek()];
                st.pop();
            }
            right[curIndex]=countOfBiggerNums;
            st.push(curIndex);
            curIndex--;
        }
        
        long res=0;
        int mod=(int)(Math.pow(10,9)+7);
        for(int i=0;i<inputSize;i++){
            // System.out.println(left[i]+" "+right[i]+" "+arr[i]);
            res = (res + ((long)arr[i]*(left[i]*right[i])))%mod;
        }
        return (int)(res);
        
    }
}