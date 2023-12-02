class Solution {
    public int minExtraChar(String s, String[] dictionary) {
    Map<Integer, Integer> processedWords = new HashMap<>();
    return findMinExtra(
        0,
        s,
        new HashSet<String>(Arrays.asList(dictionary)),
        processedWords);
  }

  public int findMinExtra(int index,String s, HashSet<String> dictionary, Map<Integer, Integer> processedWords) {
    if (index == s.length()) {
      return 0;
    }

    if (processedWords.containsKey(index)) {
      return processedWords.get(index);
    }

    int count = Integer.MAX_VALUE;

    // skip this character
    count = Math.min(count, 1 + findMinExtra(index + 1,s, dictionary, processedWords));

    // take this character
    for (int i = index; i < s.length(); i++) {
      if (dictionary.contains(s.substring(index, i + 1))) {
        count = Math.min(count, findMinExtra(i + 1,s, dictionary, processedWords));
      }
    }
    processedWords.put(index, count);
    return count;
  }
}