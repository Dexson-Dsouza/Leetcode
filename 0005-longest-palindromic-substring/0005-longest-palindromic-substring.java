class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        
        for(int i=0;i<s.length();i++){
            //odd len : abbbbbc
            int l1=expand(s,i,i);
            if(l1>maxLen){
                maxLen=l1;
                start = i - l1/2;
            }
            //even len : abbbbc
            int l2=expand(s,i,i+1);
            if(l2>maxLen){
                maxLen=l2;
                start = i - l2/2 + 1;
            }
        }
        return s.substring(start,start+maxLen);
    }
    
    int expand(String s,int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return (j-i-1);
    }
}