class Solution {
    public int countBinarySubstrings(String s) {
        int index=0;
        int prevCount=0;
        int res=0;
        while(index<s.length()){
            char cur = s.charAt(index);
            int curCount = 0;
            while(index<s.length() && s.charAt(index)==cur){
                curCount++;
                index++;
            }
            res+=Math.min(prevCount,curCount);
            prevCount=curCount;
        }
        return res;
    }
}