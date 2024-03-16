class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        return check(str1,0,str2,0);
    }
    
    public boolean check(String str1, int i, String str2, int j) {
        if(j==str2.length()){
            return true;
        }
        if(i==str1.length()){
            return false;
        }
        
        int sCharIndex = str1.charAt(i)-'a';
        int tCharIndex = str2.charAt(j)-'a';
        if(sCharIndex==tCharIndex || (sCharIndex==25 && tCharIndex==0) || (sCharIndex+1==tCharIndex)){
            return check(str1,i+1,str2,j+1);
        }else{
            return check(str1,i+1,str2,j);
        }
    }
}