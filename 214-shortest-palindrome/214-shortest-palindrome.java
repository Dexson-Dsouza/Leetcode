class Solution {
    public String shortestPalindrome(String s) {
        
        StringBuilder reverseInput= new StringBuilder(s);
        
        reverseInput.reverse();
        String str = s + "$" +reverseInput.toString();
        
        int[] kmp=new int[str.length()];
        
        for(int i=1;i<str.length();i++){
            int index=kmp[i-1];
            
            while(index>0 && str.charAt(index)!=str.charAt(i)){
                index = kmp[index-1];
            }
            
            if(str.charAt(index)==str.charAt(i)){
                index++; 
            }
            kmp[i]=index;
            
        }
        int palLength=kmp[str.length()-1];
        StringBuilder extraString = new StringBuilder(s.substring(palLength));
        extraString.reverse();
        
        return extraString.toString() + s;
    }
}