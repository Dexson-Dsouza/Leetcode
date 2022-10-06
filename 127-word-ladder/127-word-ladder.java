class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        
        if(wordSet.contains(endWord)==false){
            return 0;
        }
        int length=1;
        Queue<String> wordQueue=new LinkedList<>();
        wordQueue.add(beginWord);
        wordSet.remove(beginWord);
        while(wordQueue.size()>0){
            int curSize=wordQueue.size();
            Set<String> removedWords=new HashSet<>();
            while(curSize>0){
                curSize--;
                String curWord=wordQueue.poll();
                if(curWord.equals(endWord)){
                    return length;
                }
                for(int i=0;i<curWord.length();i++){
                    char[] curWordArr=curWord.toCharArray();
                    for(int j=0;j<26;j++){
                        curWordArr[i]=(char)('a'+j);
                        String nextWord=new String(curWordArr);
                        if(wordSet.contains(nextWord)){
                            removedWords.add(nextWord);
                            wordQueue.add(nextWord);
                        }
                    }
                }
            }
            for(String word:removedWords){
                wordSet.remove(word);
            }
            length++;
        }
        return 0;
    }
}