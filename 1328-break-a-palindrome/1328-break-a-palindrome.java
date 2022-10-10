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
        int right=len-1;
        if(len%2==1){
            mid++;
        }
        while(right>=mid && replaced==false){
            if(str[right]=='a'){
                str[right]='b';
                replaced=true;
            }
            right--;
        }
        
        
        return new String(str);
    }
}