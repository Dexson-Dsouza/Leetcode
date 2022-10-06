class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        if(!set.contains(endWord))
            return 0;
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int level=1;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String currWord=queue.poll();
                char[]wordChar=currWord.toCharArray();
                for(int j=0;j<wordChar.length;j++){
                    char oldChar=wordChar[j];
                    for(char c='a';c<='z';c++){
                        if(oldChar==c) continue;
                        wordChar[j]=c;
                        String newWord=String.valueOf(wordChar);
                        if(newWord.equals(endWord))
                            return level+1;
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChar[j]=oldChar;
                }
            }
            level++;
        }
        
        return 0;
    }
}