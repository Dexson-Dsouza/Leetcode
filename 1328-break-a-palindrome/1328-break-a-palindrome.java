class Solution {
    public String breakPalindrome(String palindrome) {
        int len=palindrome.length();
        if(len==1){
            return "";
        }
        
        char[] str=palindrome.toCharArray();
        boolean replaced=false;
        int left=0;
        int mid=len/2;
        while(left<mid && replaced==false){
            if(str[left]!='a'){
                str[left]='a';
                replaced=true;
            }
            left++;
        }
        if(!replaced){
        str[len-1]='b';
        }
        return new String(str);
    }
}