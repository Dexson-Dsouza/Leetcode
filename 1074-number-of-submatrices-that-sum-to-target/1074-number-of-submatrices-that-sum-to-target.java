class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        
        int rows=matrix.length;
        int cols=matrix[0].length;
        
        int result=0;
        
        int curSum=0;
        for(int row1=0;row1<rows;row1++){
            int[] prefixSum=new int[cols];
            
            for(int row2=row1;row2<rows;row2++){
                for(int col=0;col<cols;col++){
                    prefixSum[col]+=matrix[row2][col];
                }
                result += findTargetSum(prefixSum,target);
            }   
        }
        
        return result;
    }
    
    int findTargetSum(int[] arr,int target){
        Map<Integer,Integer> sumCount=new HashMap<>();
        sumCount.put(0,1);
        int curSum=0;
        int targetSumCount=0;
        for(int n:arr){
            curSum+=n;
            targetSumCount+=sumCount.getOrDefault(curSum-target,0);
            sumCount.put(curSum,sumCount.getOrDefault(curSum,0)+1);
        }
        return targetSumCount;
    }
}