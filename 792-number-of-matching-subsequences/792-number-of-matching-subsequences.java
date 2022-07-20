class wordIndexPair{
    String word;
    int index;
    wordIndexPair(String word){
        this.word=word;
        index=0;
    }
}
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Queue<wordIndexPair>> wordIndexPairList=new ArrayList<>();

        for(int i=0;i<26;i++){
            wordIndexPairList.add(new LinkedList<>());
        }
        
        for(String word:words){
            wordIndexPair t=new wordIndexPair(word);
            t.word=word;
            t.index=0;
            wordIndexPairList.get(word.charAt(0)-'a').add(t);
        }
        
        int matchedWordCount=0;
        for(char ch:s.toCharArray()){
            Queue<wordIndexPair> curCharQueue=wordIndexPairList.get(ch-'a');
            int curSize=curCharQueue.size()-1;
            while(curSize-->=0){

                wordIndexPair cur=curCharQueue.peek();
                String curWordString=cur.word;
                int index=cur.index;
                curCharQueue.poll();
                if(cur.word.charAt(index)==ch){
                    cur.index++;
                }
                if(cur.index==cur.word.length()){
                    matchedWordCount++;
                    // wordIndexPairList.remove
                }else{
                    wordIndexPairList.get(cur.word.charAt(cur.index)-'a').add(cur);
                }
                
                
            }
        }
        return matchedWordCount;
    }
}