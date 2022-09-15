class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations=new ArrayList<>();
        findCombos(candidates,0,target,new LinkedList<Integer>(),combinations);
        return combinations;
    }
    
    public void findCombos(int[] candidates, int i, int target, Deque<Integer> curCombo, List<List<Integer>> combinations){
        if(i==candidates.length){
            return;
        }
        if(target==0){
            combinations.add(new ArrayList<>(curCombo));
            return;
        }
        if(candidates[i]<=target){
            curCombo.addLast(candidates[i]);
            findCombos(candidates,i,target-candidates[i],curCombo,combinations);
            curCombo.pollLast();
        }
        findCombos(candidates,i+1,target,curCombo,combinations);
    }
}