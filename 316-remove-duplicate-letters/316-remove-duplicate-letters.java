class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt=new int[26];
        boolean[] visited=new boolean[26];
        
        for(char ch:s.toCharArray()){
            cnt[ch-'a']++;
        }
        
        Stack<Character> st=new Stack<>();
        
        for(char ch:s.toCharArray()){
            int index=ch-'a';
            cnt[index]--;
            if(visited[index]){
                continue;
            }
            
            while(st.size()>0 && ch<st.peek() && cnt[st.peek()-'a']>0){
                visited[st.pop()-'a']=false;
            }
            st.push(ch);
            visited[index]=true;
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}