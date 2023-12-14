/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.lang.constant.Constable;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> currentCombo = new ArrayList<>();
    // dfs
    findCombos(0, candidates, target, currentCombo, combinations);
    return combinations;
  }

  private void findCombos(int index, int[] candidates, int target, List<Integer> currentCombo,
      List<List<Integer>> combinations) {
    if (target == 0) {
      combinations.add(new ArrayList<>(currentCombo));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      if(target<candidates[i]){
        continue;
      }
      currentCombo.add(candidates[i]);
      findCombos(i + 1, candidates, target - candidates[i], currentCombo, combinations);
      currentCombo.remove(currentCombo.size() - 1);
    }

  }
}