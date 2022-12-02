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
        
        PriorityQueue<wordCountPair> pq=new PriorityQueue<>(
            (a,b)-> a.count==b.count? b.word.compareTo(a.word):a.count-b.count);
        
        for(wordCountPair wp : arr){
            pq.add(wp);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        for(int i=0;i<k;i++){
            kMostFreqWords.add(pq.poll().word);
        }
        Collections.reverse(kMostFreqWords);
        return kMostFreqWords;
    }
}