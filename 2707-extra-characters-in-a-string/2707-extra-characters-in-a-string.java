class Solution {
    public int minExtraChar(String s, String[] dictionary) {
    Map<String, Integer> processedWords = new HashMap<>();
    return findMinExtra(
        s,
        new HashSet<String>(Arrays.asList(dictionary)),
        processedWords);
  }

  public int findMinExtra(String s, HashSet<String> dictionary, Map<String, Integer> processedWords) {
    if (s.length() == 0) {
      return 0;
    }

    if (processedWords.containsKey(s)) {
      return processedWords.get(s);
    }

    int count = Integer.MAX_VALUE;

    // skip this character
    count = Math.min(count, 1 + findMinExtra(s.substring(1), dictionary, processedWords));

    // take this character
    for (int i = 0; i < s.length(); i++) {
      if (dictionary.contains(s.substring(0, i + 1))) {
        count = Math.min(count, findMinExtra(s.substring(i + 1), dictionary, processedWords));
      }
    }
    processedWords.put(s, count);
    return count;
  }
}