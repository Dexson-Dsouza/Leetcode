class Solution {
    public String reverseParentheses(String s) {
        StringBuilder rev = new StringBuilder();
        Stack<Integer> leftBraces = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur=='('){
                leftBraces.push(rev.length());
            }else if(cur==')'){
                int start = leftBraces.pop();
                int end = rev.length()-1;
                rev = reverse(rev,start,end);
            }else{
                rev.append(cur);
            }
            // System.out.println(rev);
        }
        return rev.toString();
    }
    
    StringBuilder reverse(StringBuilder rev, int start, int end){
        char[] temp = rev.toString().toCharArray();
        while(start<end){
            char t = temp[start];
            temp[start] = temp[end];
            temp[end] = t;
            start++;
            end--;
        }
        rev = new StringBuilder(new String(temp));
        return rev;
    }
}