class Solution {
    public boolean isSubsequence(String s, String t) {
        int start=0;
        int indexInTarget=0;
        while(start<s.length() && indexInTarget<t.length()){
            if(s.charAt(start)==t.charAt(indexInTarget)){
                start++;
            }
            indexInTarget++;
        }
        return start==s.length();
    }
}