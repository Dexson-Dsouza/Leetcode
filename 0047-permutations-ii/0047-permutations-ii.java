class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> digitMap = new HashMap<>();
        for (int n : nums) {
          digitMap.put(n, digitMap.getOrDefault(n, 0) + 1);
        }
        List<Integer> currentPerm = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        generatePerm(nums.length,digitMap, currentPerm, permutations);
        return permutations;
      }

      void generatePerm(int total, Map<Integer, Integer> digitMap, List<Integer> currentPerm, List<List<Integer>> permutations) {
        if (total == currentPerm.size()) {
          permutations.add(new ArrayList<>(currentPerm));
          return;
        }

        for(int n:digitMap.keySet()){
          if(digitMap.get(n)==0){
            continue;
          }
          currentPerm.add(n);
          digitMap.put(n,digitMap.get(n)-1);
          generatePerm(total,digitMap, currentPerm, permutations);
          currentPerm.remove(currentPerm.size()-1);
          digitMap.put(n,digitMap.get(n)+1);
        }
      }
}