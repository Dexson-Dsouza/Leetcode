class Solution {
    public String breakPalindrome(String palindrome) {
        char[] strArr = palindrome.toCharArray();
        
        int index = 0;
        int len = strArr.length;
        if(len==1){
            return "";
        }
        
        int mid = len/2;
        while(index<mid && strArr[index]=='a'){
            index++;
        }
        if(index==mid){
            strArr[len-1]='b';
        }else{
            strArr[index]='a';
        }
        return new String(strArr);
    }
}