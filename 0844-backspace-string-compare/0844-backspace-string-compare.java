class Solution {
    public boolean backspaceCompare(String s, String t) {
        String sourceString = buildString(s);
        String targetString = buildString(t);
        return sourceString.compareTo(targetString)==0;
    }
    
    public String buildString(String s){
        StringBuilder revSource = new StringBuilder();
        
        int skipCount = 0;
        for(int i=s.length()-1;i>=0;i--){
            char curChar = s.charAt(i);
            if(curChar =='#'){
                skipCount++;
            }else{
                if(skipCount>0){
                    skipCount--;
                }else{
                    revSource.append(curChar);
                }
            }
        }
        return revSource.toString();
    }
}