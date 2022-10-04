class Solution {
    public int maxDepth(String s) {
        int maxDepth=0;
        int l=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                l++;
            }else if(ch==')'){
                l--;
            }
            maxDepth=Math.max(maxDepth,l);
        }
        return maxDepth;
    }
}