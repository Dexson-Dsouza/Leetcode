class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        int maxLen = 0;
        for(String w:words){
            maxLen = Math.max(maxLen,w.length());
        }
        Arrays.sort(words,(a,b)->a.length() - b.length());
        
        Set<String> foundWords = new HashSet<>();
        
        for(String word:words){
            if(found(0,word,wordSet)){
                foundWords.add(word);
            }    
            wordSet.add(word);
        }
        return new ArrayList<>(foundWords);
    }
    
    public boolean found(int i, String w, Set<String> wordSet){
        if(i==w.length()){
            return true;
        }
        
        for(int index = i;index<w.length();index++){
            if(wordSet.contains(w.substring(i,index+1)) && found(index+1,w,wordSet)==true){
                return true;
            }
        }
        return false;
    }
}