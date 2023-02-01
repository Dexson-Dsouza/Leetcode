class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length){
            return false;
        }
        HashSet<String> words = new HashSet<>();
        for(List<String> pair:similarPairs){
            words.add(pair.get(0)+"*"+pair.get(1));
        }
        
        for(int i = 0; i<sentence1.length; i++){
            if(sentence1[i].equals(sentence2[i])){
                continue;
            }
            String k1 = sentence1[i] +"*"+sentence2[i];
            String k2 = sentence2[i] +"*"+sentence1[i];
            if(words.contains(k1) || words.contains(k2)){
                continue;
            }
            return false;
        }
        return true;
    }
}