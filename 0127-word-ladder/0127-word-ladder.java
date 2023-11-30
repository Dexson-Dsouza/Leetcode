class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        wordSet.remove(beginWord);
        Queue<String> currentWords = new LinkedList<>();
        visited.add(beginWord);
        currentWords.add(beginWord);
        int wCount = 1;
        if(wordList.contains(endWord)==false){
          return 0;
        }
        if(beginWord.equals(endWord)){
            return wCount;
        }
        boolean foundWord = false;
        while(currentWords.size()>0 && !foundWord){
          wCount++;
          int curQueueSize = currentWords.size();
          while(curQueueSize>0){
              curQueueSize--;
            String currentWord = currentWords.poll();
            for(String neighbour: getAdjStrings(currentWord, wordSet)){
              wordSet.remove(neighbour);
              currentWords.add(neighbour);
                // System.out.println(neighbour+" "+wCount);
              if(neighbour.equals(endWord)){
                  foundWord=true;
                break;
              }
            }
          }
        }
        return foundWord?wCount:0;
    }
    
    public static List<String> getAdjStrings(String s, Set<String> wordSet){
    char[] strArr = s.toCharArray();
    List<String> adjStringList = new ArrayList<>();
    for(int i=0;i<s.length();i++){
      char currentChar = strArr[i];
      for(int charIndex=0;charIndex<26;charIndex++){
        char adjChar = (char)('a'+charIndex);
        if(adjChar!=currentChar){
          strArr[i] = adjChar;
          String adjStr = new String(strArr);
          strArr[i] = currentChar;
          if(wordSet.contains(adjStr)){
            adjStringList.add(adjStr);
          }
        }
      }
    }
    return adjStringList;
  }
    
    
}