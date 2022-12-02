class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        int[] charCount1 = new int[26];
        
        for(char c:word1.toCharArray()){
            charCount1[c-'a']++;
        }
        
        int[] charCount2 = new int[26];
        
        for(char c:word2.toCharArray()){
            charCount2[c-'a']++;
        }
        
        for(int curChar=0;curChar<26;curChar++){
            int count1 = charCount1[curChar];
            int count2 = charCount2[curChar];
            
            if(count1!=count2){
                if(count1==0 || count2==0){
                    return false;
                }
                for(int index = 0; index < 26;index++){
                    if(charCount2[index]==count1){
                        int t = charCount2[index];
                        charCount2[index] = count2;
                        charCount2[curChar] = t;
                        count2 = charCount2[curChar];
                        break;
                    }
                }
                
                if(count1!=count2){
                    return false;
                }
                charCount1[curChar] = charCount2[curChar] = -count1;
            }
        }
        
        return true;
    }
}