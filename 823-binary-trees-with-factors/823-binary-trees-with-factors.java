class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int inputSize=arr.length;
        Map<Integer,Long> waysToCreate=new HashMap<>(); // key -> root value and value-> num of ways 
        Arrays.sort(arr);
        int mod= (int)(Math.pow(10,9)+7);
        for(int n:arr){
            long ways=1;
            for(int left:waysToCreate.keySet()){
                int right=n/left;
                
                if(left*right ==n && waysToCreate.containsKey(right)){
                    ways = (ways + waysToCreate.get(left)*waysToCreate.get(right))%mod;
                }
            }
            waysToCreate.put(n,ways);
        }
        
        long totalWays=0;
        for(int root:waysToCreate.keySet()){
            totalWays = (totalWays+waysToCreate.get(root))%mod;
        }
        return (int)(totalWays);
    }
}