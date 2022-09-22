class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        StringBuilder reversedString=new StringBuilder();
        
        for(String word:words){
            StringBuilder wordSb=new StringBuilder(word);
            reversedString.append(wordSb.reverse().toString()+" ");
        }
        reversedString.setLength(reversedString.length()-1);
        
        return reversedString.toString();
    }
}