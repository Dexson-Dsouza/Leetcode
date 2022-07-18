class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> sequenceLength=new HashMap<>();
        int longestLength=0;
        
        for(int n:arr){
            sequenceLength.put(n,sequenceLength.getOrDefault(n-difference,0)+1);
            longestLength = Math.max(longestLength,sequenceLength.get(n));
        }
        return longestLength;
    }
}