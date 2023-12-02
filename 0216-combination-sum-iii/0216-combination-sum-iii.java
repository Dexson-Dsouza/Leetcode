class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    findCombos(1, k, n, currentList, res);
    return res;
  }

  public static void findCombos(int digit, int k, int n, List<Integer> currentList, List<List<Integer>> res) {
    
    if (k == 0) {
      if (n == 0) {
        res.add(new ArrayList<>(currentList));
      }
      return;
    }
    if (n < 0 || digit>9) {
      return;
    }
    currentList.add(digit);
    findCombos(digit + 1, k - 1, n - digit, currentList, res);
    currentList.remove(currentList.size() - 1);
    findCombos(digit + 1, k, n, currentList, res);

  }
}