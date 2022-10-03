class Solution {
    public String minRemoveToMakeValid(String s) {
        int len=s.length();
        boolean[] taken=new boolean[len];
        char[] arr=s.toCharArray();
        Stack<Integer> st=new Stack();
        
        for(int i=0;i<len;i++){
            if(arr[i]=='('){
                st.push(i);
            }else if(arr[i]==')'){
                if(st.size()>0){
                    taken[st.pop()]=true;
                    taken[i]=true;
                }
            }else{
                taken[i]=true;
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<len;i++){
            if(taken[i]){
                res.append(arr[i]);
            }
        }
        return res.toString();
    }
}