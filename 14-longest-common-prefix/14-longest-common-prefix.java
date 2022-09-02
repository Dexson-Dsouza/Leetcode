class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len=0;
        int index=0;
        while(index<strs[0].length()){
            boolean match=true;
            char curChar=strs[0].charAt(index);
            for(String w:strs){
                if(index>=w.length() || w.charAt(index)!=curChar){
                    match=false;
                    break;
                }
            }
            
            if(match==false){
                break;
            }
            index++;
            len++;
        }
        return strs[0].substring(0,len);
    }
}