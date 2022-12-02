class wordCountPair{
    String word;
    int count;
    wordCountPair(String word){
        this.word=word;
        count=1;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<wordCountPair> arr=new ArrayList<>();
        Map<String,Integer> wordIndexes=new HashMap<>();
        
        for(String word:words){
            if(wordIndexes.containsKey(word)){
                int index=wordIndexes.get(word);
                arr.get(index).count++;
            }else{
                wordIndexes.put(word,arr.size());
                arr.add(new wordCountPair(word));
            }
        }
        List<String> kMostFreqWords=new ArrayList<>();
        arr.sort((a,b)->(a.count==b.count?a.word.compareTo(b.word):b.count-a.count));
        
        for(int wordIndex=0;wordIndex<k;wordIndex++){
            kMostFreqWords.add(arr.get(wordIndex).word);
        }
        return kMostFreqWords;
    }
}