class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
            
        int start=0;
        int maxLen=0;

        for(int i=0;i<s.length();i++){
            int len1=extend(s,i,i);
            int len2=extend(s,i,i+1);
            int len=Math.max(len1,len2);

            if(len>maxLen){
                start=i-((len-1)/2);
                maxLen= len;
            }
        }
        return s.substring(start,start+maxLen);
        
    }
    
    public int extend(String s,int left,int right){
        if(s==null||left>right)
            return 0;
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}