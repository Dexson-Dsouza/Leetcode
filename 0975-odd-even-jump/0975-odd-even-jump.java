class Solution {
    public int oddEvenJumps(int[] arr) {
        int length=arr.length;

        TreeMap<Integer,Integer> numIndexMap=new TreeMap<>();        
        boolean[][] dp=new boolean[length][2]; 
        // [i][0] can reach end from i with odd jump
        // [i][1] can reach end with even jump
        
        dp[length-1][0]=dp[length-1][1]=true;
        
        Integer count=0;
        
        for(int i=length-1;i>=0;i--){
            Integer oddJumpNum=numIndexMap.ceilingKey(arr[i]);
            if(oddJumpNum!=null){
                int oddJumpIndex=numIndexMap.get(oddJumpNum);
                dp[i][1]=dp[oddJumpIndex][0];
            }
            
                
            Integer evenJumpNum=numIndexMap.floorKey(arr[i]);
            if(evenJumpNum!=null){
                int evenJumpIndex=numIndexMap.get(evenJumpNum);
                dp[i][0]=dp[evenJumpIndex][1];
            }
            
            numIndexMap.put(arr[i],i);
            
            if(dp[i][1]==true){
                count++;
            }
            
        }
        
        return count;
        
    }
}