class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> numSet=new HashSet<>();
        Set<Integer> doneSet=new HashSet<>();
        int pairCount = 0;
        for(int n:nums){
            int prevPair = n - k;
            if(doneSet.contains(n)){
                continue;
            }
            if(numSet.contains(prevPair)){
                pairCount++;
                doneSet.add(n);
            }
            numSet.add(n);
        }
        return pairCount;
    }
}