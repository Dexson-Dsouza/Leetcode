class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer,Long> treeCount = new HashMap<>();
        
        Arrays.sort(arr);
        
        long totalCount = 0;
        int mod = (int)(Math.pow(10,9))+7;
        for(int i=0;i<arr.length;i++){
            long curCount=1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int leftChild = arr[j];
                    long leftCount = treeCount.getOrDefault(leftChild,0L);
                    int rightChild = arr[i]/arr[j];
                    long rightCount = treeCount.getOrDefault(rightChild,0L);
                    long total = (leftCount*rightCount)%mod;
                    curCount = (curCount+total)%mod;
                    // System.out.println(leftChild+" "+rightChild+" "+total);
                }
            }
            // System.out.println(arr[i]+" "+curCount);
            treeCount.put(arr[i],curCount);
            totalCount = (totalCount + curCount)%mod;
        }
        return (int)totalCount;
    }
}