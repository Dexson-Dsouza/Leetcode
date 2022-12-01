class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result=new HashSet<>();
        int maxParenthesis = 0;
        int left = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;
            }
            if(ch==')'){
                if(left>0){
                    left--;
                    maxParenthesis++;
                }
            }
        }
        StringBuilder currentPerm=new StringBuilder();
        generatePerms(s,0,0,0,maxParenthesis,result,currentPerm);
        return new ArrayList<>(result);
    }
    
    public void generatePerms(String s, int i, int l, int r, int maxP, Set<String> result,
                              StringBuilder currentPerm){
        // System.out.println(currentPerm+" "+i);
        if(i==s.length()){
            // System.out.println(currentPerm+" "+l+" "+r +" "+ maxP);
            if(l==r && l == maxP){
                result.add(currentPerm.toString());
            }
            return;
        }
        char cur = s.charAt(i);
        if(cur=='('){
            if(l<maxP){
                currentPerm.append(cur);
                generatePerms(s,i+1,l+1,r,maxP,result,currentPerm);
                currentPerm.deleteCharAt(currentPerm.length()-1);
            }
            generatePerms(s,i+1,l,r,maxP,result,currentPerm);
        }else if(cur==')'){
            if(l>r){
                currentPerm.append(cur);
                generatePerms(s,i+1,l,r+1,maxP,result,currentPerm);
                currentPerm.deleteCharAt(currentPerm.length()-1);
            }
            generatePerms(s,i+1,l,r,maxP,result,currentPerm);
        }else{
            currentPerm.append(cur);
            generatePerms(s,i+1,l,r,maxP,result,currentPerm);
            currentPerm.deleteCharAt(currentPerm.length()-1);
        }
        
    }
}