class Solution {
    public String longestPrefix(String s) {
        int[] kmp = new int[s.length()];
        
        for(int i=1;i<s.length();i++){
            int index = kmp[i-1];
            
            while(index>0 && s.charAt(index)!=s.charAt(i)){
                index=kmp[index-1];
            }
            
            if(s.charAt(index)==s.charAt(i)){
                index++;
            }
            kmp[i]=index;
        }
        
        return s.substring(s.length()-kmp[s.length()-1]);
    }
}