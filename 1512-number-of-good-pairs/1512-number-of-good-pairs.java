class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        
        int pairs=0;
        for(int n:nums){
            int count = m.getOrDefault(n,0);
            pairs+=count;
            m.put(n,count+1);
        }
        return pairs;
    }
}