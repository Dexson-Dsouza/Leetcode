class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
String encodedInput=encode(pattern);
	List<String> matchedWords=new ArrayList<>();

for(String word:words){
	String encodedWord=encode(word);
	if(encodedWord.equals(encodedInput)){
		matchedWords.add(word);
}
}
return matchedWords;
}

public String encode(String pattern){
    StringBuilder encodedPattern=new StringBuilder();
char curEncoderChar='a';
Map<Character,Character> inputMapping=new HashMap<>();

for(char ch:pattern.toCharArray()){
	if(inputMapping.containsKey(ch)==false){
	inputMapping.put(ch,curEncoderChar);
	curEncoderChar+=1;
}
encodedPattern.append(inputMapping.get(ch));
}
return encodedPattern.toString();
}


}