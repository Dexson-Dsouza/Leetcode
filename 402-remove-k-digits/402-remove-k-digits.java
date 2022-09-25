class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        
        for(char ch:num.toCharArray()){
            while(st.size()>0 && k>0 && ch<st.peek()){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k>0 && st.size()>0){
            st.pop();
            k--;
        }
        
        StringBuilder smallNum=new StringBuilder();
        while(st.size()>0){
            smallNum.append(st.pop());
        }
        
        if(smallNum.length()==0){
            smallNum.append("0");
        }
        smallNum.reverse();
        while(smallNum.length()>1 && smallNum.charAt(0)=='0'){
            smallNum.deleteCharAt(0);
        }
        
        return smallNum.toString();
    }
}