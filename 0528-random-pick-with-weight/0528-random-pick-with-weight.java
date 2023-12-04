class Solution {
    int[] sumArr;

  public Solution(int[] w) {
    sumArr = w.clone();
    for (int i = 1; i < w.length; i++) {
      sumArr[i] += sumArr[i - 1];
    }
  }

  public int pickIndex() {
    int totalSum = sumArr[sumArr.length - 1];
    int randomWeight = (int) (Math.random() * totalSum);
    int index = 0;
    while (sumArr[index] <= randomWeight) {
      index++;
    }
    return index;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */