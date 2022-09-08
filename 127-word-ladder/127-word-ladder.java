class Solution {
    public boolean canTransform(String a, String b){
        int len=a.length();
        int differnceCharCount=0;
        for(int i=0;i<len;i++){
            if(a.charAt(i)!=b.charAt(i)){
                differnceCharCount++;
            }
        }
        return differnceCharCount==1;
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Set<String>> adj=new HashMap<>();
        
        Set<String> words=new HashSet<>();
        for(String word:wordList){
            adj.put(word,new HashSet<>());
            words.add(word);
        }
        
        if(words.contains(endWord)==false){
            return 0;
        }
        
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                String wordA=wordList.get(i);
                String wordB=wordList.get(j);
                if(canTransform(wordA,wordB)){
                    adj.get(wordA).add(wordB);
                    adj.get(wordB).add(wordA);
                }
            }
        }
        
        adj.put(beginWord,new HashSet<>());
        for(int i=0;i<wordList.size();i++){
            String wordA=wordList.get(i);
            if(canTransform(wordA,beginWord)){
                adj.get(beginWord).add(wordA);
                adj.get(wordA).add(beginWord);
            }
        }
        
        Queue<String> curWords=new LinkedList<>();
        curWords.add(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int steps=0;
        while(curWords.size()>0){
            int curSize=curWords.size();
            // System.out.println(steps+"+---------------");
            while(curSize>0){
                curSize--;
                String curWord=curWords.poll();
                
                // System.out.println(curWord);
                if(curWord.equals(endWord)){
                    return steps+1;
                }
                for(String nextWord:adj.get(curWord)){
                    if(visited.contains(nextWord)==false){
                        visited.add(nextWord);
                        curWords.add(nextWord);
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}