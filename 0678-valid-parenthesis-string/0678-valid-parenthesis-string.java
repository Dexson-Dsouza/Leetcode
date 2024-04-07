class Solution {
    public boolean checkValidString(String s) {
        int empty=0;
        for(char ch:s.toCharArray()){
            if(ch=='*' || ch=='('){
                empty++;
            }
            if(ch==')'){
                empty--;
            }
            if(empty<0){
                return false;
            }
        }
        
        empty=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='*' || ch==')'){
                empty++;
            }
            if(ch=='('){
                empty--;
            }
            if(empty<0){
                return false;
            }
        }
        return true;
    }
}