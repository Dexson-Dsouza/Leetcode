class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int result=Integer.MAX_VALUE;
        int prevSmallest=Integer.MAX_VALUE;
        
        Queue<int[]> prevValidSubArrays=new LinkedList<>();
        
        int startPointer=0;
        int endPointer=0;
        int curSum=0;
        int inputLength=arr.length;
        
        while(endPointer<inputLength){
            
            // System.out.println(startPointer+" "+endPointer+" "+prevSmallest+" "+curSum);
            
            curSum+=arr[endPointer];
            
            
            while(curSum>=target){
                if(curSum==target){
                    int curLen=endPointer-startPointer+1;
                    // System.out.println(curLen+" "+prevSmallest+"___"+startPointer+" "+endPointer);
                    prevValidSubArrays.add(new int[]{endPointer,curLen});
                    if(prevSmallest!=Integer.MAX_VALUE){
                        result=Math.min(result,prevSmallest+curLen);
                    }
                    
                }
                curSum-=arr[startPointer];
                startPointer++;
                while(prevValidSubArrays.size()>0 && prevValidSubArrays.peek()[0]<startPointer){
                    prevSmallest=Math.min(prevSmallest,prevValidSubArrays.poll()[1]);
                }
            }
            endPointer++;
            
            
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}