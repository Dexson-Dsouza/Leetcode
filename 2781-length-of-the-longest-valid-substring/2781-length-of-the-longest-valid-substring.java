class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int start=0;
        int curIndex=0;
        int maxLen = 0;
        Set<String> words=new HashSet<>(forbidden);
        while(curIndex<word.length()){
            // check 10 substring to make valid word
            
            for(int i=curIndex;i>=start && i>curIndex-10;i--){
                String resSubString = word.substring(i,curIndex+1);
                // System.out.println(resSubString+" "+curIndex);
                if(words.contains(resSubString)){
                    start=i+1;
                    break;
                }
            }
            maxLen = Math.max(maxLen,curIndex-start+1);
            curIndex++;
        }
        return maxLen;
    }
}