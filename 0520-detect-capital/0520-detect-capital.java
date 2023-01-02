class Solution {
    public boolean detectCapitalUse(String word) {
        int capCount = 0;
        for(char ch:word.toCharArray()){
            if(isCap(ch)){
                capCount++;
            }
        }
        if(capCount==0){
            return true;
        }
        if(capCount == 1 && isCap(word.charAt(0))){
            return true;
        }
        if(capCount == word.length()){
            return true;
        }
        return false;
    }
    
    boolean isCap(char ch){
        return ch>='A' && ch<='Z';
    }
}