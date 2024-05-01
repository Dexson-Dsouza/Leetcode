class Solution {
    public String reversePrefix(String word, char ch) {
        String reversedStr=word;
        
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            if(cur==ch){
                StringBuilder firstHalf = new StringBuilder(word.substring(0,i+1));
                StringBuilder secondHalf = new StringBuilder(word.substring(i+1));
                reversedStr = firstHalf.reverse().toString()+secondHalf.toString();
                break;
            }
        }
        return reversedStr;
    }
}