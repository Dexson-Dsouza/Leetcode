class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result=new HashSet<>();
        
        StringBuilder sb=new StringBuilder();
        int maxParenthesis=0;
        int left=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++; 
            }else if(ch==')'){
                if(left>0){
                    left--;
                }else{
                    maxParenthesis++;
                }
            }
        }
        maxParenthesis+=left;
        generatePerms(s,0,sb,0,maxParenthesis,result);
        return new ArrayList<>(result);
    }
    
    void generatePerms(String s, int i, StringBuilder sb, int left, int maxParenthesis, Set<String>result){
        if(left<0){
            return;
        }
        if(i==s.length()){
            // System.out.println(sb+" "+left+" "+maxParenthesis);
            if(maxParenthesis==0 && left==0){
                result.add(sb.toString());
            }
            return;
        }
        
        generatePerms(s,i+1,sb,left,maxParenthesis-1,result);
        sb.append(s.charAt(i));
        if(s.charAt(i)=='('){
            generatePerms(s,i+1,sb,left+1,maxParenthesis,result);
        }else if(s.charAt(i)==')'){
            generatePerms(s,i+1,sb,left-1,maxParenthesis,result);
        }else{
            generatePerms(s,i+1,sb,left,maxParenthesis,result);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}