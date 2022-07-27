class Solution {
    public int maximumSum(int[] arr) {
        int totalElements=arr.length;
        if(totalElements==1){
            return arr[0];
        }
        int[] left=new int[totalElements];
        int[] right=new int[totalElements];
        int res=Integer.MIN_VALUE;
        int curSum=0;
        for(int i=0;i<totalElements;i++){
            left[i]=curSum;
            curSum=Math.max(arr[i],curSum+arr[i]);    
            res=Math.max(res,curSum);
        }
        
        curSum=0;
        for(int i=totalElements-1;i>=0;i--){
            right[i]=curSum;
            curSum=Math.max(arr[i],curSum+arr[i]);            
        }
        
        for(int i=0;i<totalElements;i++){
            // System.out.println(left[i] +" "+ right[i]);
            res=Math.max(res,Math.max(left[i]+right[i],arr[i]));
        }
        return res;
        
    }
}