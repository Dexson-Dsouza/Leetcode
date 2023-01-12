class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startIndex = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            int palLen1 = getLen(s,i,i);
            if(palLen1>maxLen){
                maxLen = palLen1;
                startIndex = i - palLen1/2;
            }
            
            int palLen2 = getLen(s,i,i+1);
            if(palLen2>maxLen){
                maxLen = palLen2;
                startIndex = i - palLen2/2 +1; 
            }
        }
        // System.out.println(startIndex+" "+maxLen);
        return s.substring(startIndex,startIndex+maxLen);
    }
    
    public int getLen(String s, int i, int j){
        int len = 0;
        if(i==j){
            len  = -1;
        }
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            len+=2;
        }
        return len;
    }
}