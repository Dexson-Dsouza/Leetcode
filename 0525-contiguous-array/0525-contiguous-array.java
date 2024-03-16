class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sumIndex=new HashMap<>();
        int sum=0;
        sumIndex.put(0,-1);
        
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]==0?-1:1;
            maxLen = Math.max(maxLen ,i - sumIndex.getOrDefault(sum,i+1));
            if(!sumIndex.containsKey(sum))
                sumIndex.put(sum,i);
        }
        return maxLen;
    }
}