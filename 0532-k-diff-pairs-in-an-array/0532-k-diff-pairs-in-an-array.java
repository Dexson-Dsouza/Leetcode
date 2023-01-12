class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> numSet=new HashSet<>();
        Set<String> doneSet=new HashSet<>();
        int pairCount = 0;
        for(int n:nums){
            int prevPair = n - k;
            String key1 = prevPair + "*"+n;
            if(doneSet.contains(key1)==false && numSet.contains(prevPair)){
                pairCount++;
                doneSet.add(key1);
            }
            int nextPair = n + k;
            String key2= n+"*"+nextPair;
            if(doneSet.contains(key2)==false && numSet.contains(nextPair)){
                pairCount++;
                doneSet.add(key2);
            }
            numSet.add(n);
        }
        return pairCount;
    }
}