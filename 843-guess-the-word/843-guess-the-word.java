/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words=new ArrayList<>();
        
        for(String word:wordlist){
            words.add(word);
        }
        
        for(int move=0;move<10;move++){
            int randomIndex = (int)(Math.random()*words.size());
            String currentWord=words.get(randomIndex);
            // System.out.println(currentWord + " "+ words.size());
            int matches=master.guess(currentWord);
            words=getMatchingWords(words,matches,currentWord);
        }
    }
    
    List<String> getMatchingWords(List<String> words, int matches, String currentWord){
        List<String> matchingWordList=new ArrayList<>();
        for(String word:words){
            int matchCount=0;
            for(int index=0;index<word.length();index++){
                if(word.charAt(index)==currentWord.charAt(index)){
                    matchCount++;
                }
            }
            if(matchCount==matches){
                matchingWordList.add(word);
            }
        }
        return matchingWordList;
    }
}