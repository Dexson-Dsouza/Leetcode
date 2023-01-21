class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        generateSubseq(0,nums,perm,result);
        return result;
    }
    
    public void generateSubseq(int index, int[] nums, List<Integer> perm, List<List<Integer>> result){
        if(perm.size()>=2){
            result.add(new ArrayList<>(perm));
        }
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])){
                continue;
            }
            if(perm.size()==0 || perm.get(perm.size()-1)<=nums[i]){
                perm.add(nums[i]);
                used.add(nums[i]);
                generateSubseq(i+1,nums,perm,result);
                perm.remove(perm.size()-1);
            }
        }
    }
}