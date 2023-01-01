class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        Map<Character,String> patternMap = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String w = words[i];
            if(usedWords.contains(w) || patternMap.containsKey(ch)){
                if(patternMap.getOrDefault(ch," ").equals(w)==false){
                    return false;
                }
            }else{
                usedWords.add(w);
                patternMap.put(ch,w);
            }
        }
        return true;
    }
}