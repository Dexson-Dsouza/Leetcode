class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> perm = new ArrayList<>();
        generateSubseq(0,nums,perm,result);
        return new ArrayList<>(result);
    }
    
    public void generateSubseq(int index, int[] nums, List<Integer> perm, Set<List<Integer>> result){
        if(index==nums.length){
            if(perm.size()>=2){
                result.add(new ArrayList<>(perm));
            }
            return;
        }
        if(perm.size()==0 || perm.get(perm.size()-1)<=nums[index]){
            perm.add(nums[index]);
            generateSubseq(index+1,nums,perm,result);
            perm.remove(perm.size()-1);
        }
        generateSubseq(index+1,nums,perm,result);
    }
}