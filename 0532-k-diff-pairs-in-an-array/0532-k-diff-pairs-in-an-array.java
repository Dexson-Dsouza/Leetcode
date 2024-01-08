class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> prev_nums = new HashSet<>();
        Set<Integer> processed_nums = new HashSet<>();
        int pair_count =0;
        for(int n:nums){
            if(processed_nums.contains(n)){
                continue;
            }
            if(prev_nums.contains(n-k)){
                pair_count++;
                processed_nums.add(n);
            }
            prev_nums.add(n);
        }
        return pair_count;
    }
}