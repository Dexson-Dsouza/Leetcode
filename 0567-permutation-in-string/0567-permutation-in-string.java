class Solution {
public boolean checkInclusion(String t, String s) {
    int start = 0;
    Map<Character, Integer> sCount = new HashMap<>();
    Map<Character, Integer> tCount = new HashMap<>();
    boolean exists = false;
    for (char ch : t.toCharArray()) {
      tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      sCount.put(curChar, sCount.getOrDefault(curChar, 0) + 1);
      while (sCount.get(curChar) > tCount.getOrDefault(curChar, 0)) {
        char windowStartChar = s.charAt(start);
        sCount.put(windowStartChar, sCount.get(windowStartChar) - 1);
        start++;
      }

      // check window len
      if (i - start + 1 == t.length()) {
        exists = true;
        break;
      }

    }
    return exists;
  }
}