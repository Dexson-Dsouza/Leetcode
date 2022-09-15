class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        boolean[] taken=new boolean[len];
        List<List<Integer>> permutations=new ArrayList<>();
        generateCombos(nums,taken,new LinkedList<>(),permutations,0);
        return permutations;
    }
    
    void generateCombos(int[] nums, boolean[] taken, Deque<Integer> combo, List<List<Integer>> permutations, int n){
        if(n==nums.length){
            permutations.add(new ArrayList<>(combo));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(taken[i]==false){
                taken[i]=true;
                combo.add(nums[i]);
                generateCombos(nums,taken,combo,permutations,n+1);
                combo.pollLast();
                taken[i]=false;
            }
        }
    }
}