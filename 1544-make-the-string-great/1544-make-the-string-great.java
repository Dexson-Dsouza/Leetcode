class Solution {
    public String makeGood(String s) {
        StringBuilder str=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=st.size()>0?st.peek():'*';
            char next=s.charAt(i);
            
            int curIndex=0;
            boolean isLower1=true;
            if(cur>='a' && cur<='z'){
                curIndex=cur-'a';
            }else{
                isLower1=false;
                curIndex=cur-'A';
            }
            boolean isLower2=true;
            int nextIndex=0;
            if(next>='a' && next<='z'){
                nextIndex=next-'a';
            }else{
                isLower2=false;
                nextIndex=next-'A';
            }
            
            if(curIndex==nextIndex && isLower1!=isLower2){
                st.pop();
            }else{
                st.push(next);
            }
            
        }
        
        while(st.size()>0){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}