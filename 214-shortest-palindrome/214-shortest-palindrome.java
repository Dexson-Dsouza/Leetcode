class Solution {
    public String shortestPalindrome(String s) {
        char[] str=s.toCharArray();
        int j=s.length()-1;
        
        int len = 1;
        while(j>0){
            int start=0;
            int end=j;
            while(start<end && str[start]==str[end]){
                start++;
                end--;
            }
            
            if(start>=end){
                len=(j+1);
                break;
            }
            j--;
        }
        StringBuilder result=new StringBuilder();
        int lastIndex=len;
        
        if(lastIndex<s.length()){
            StringBuilder appendPart = new StringBuilder(s.substring(lastIndex));
            result.append(appendPart.reverse().toString());
        }
        result.append(s);
        return result.toString();
    }
}