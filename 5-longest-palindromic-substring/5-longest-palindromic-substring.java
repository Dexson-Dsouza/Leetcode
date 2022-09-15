class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int maxLen=1;
        
        char[] str=s.toCharArray();
        
        for(int i=0;i<str.length-1;i++){
            int l1 = expand(str,i,i);
            if(l1>maxLen){
                maxLen=l1;
                start= i - l1/2;
            }
            
            int l2 = expand(str,i,i+1);
            
            if(l2>maxLen){
                maxLen=l2;
                start= i - l2/2 + 1;
            }
        }
        
        return s.substring(start,start+maxLen);
    }
    
    public int expand(char[] arr, int start, int end){
        while(start>=0 && end<arr.length && arr[start]==arr[end]){
            start--;
            end++;
        }
        return end-start-1;
    }
    
}