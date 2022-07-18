class Solution {
    public String decodeString(String s) {
        Stack<String> prevString=new Stack<>();
        Stack<Integer> multiplier=new Stack<>();
        
        StringBuilder currentString=new StringBuilder();
        for(int index=0;index<s.length();index++){
            // System.out.println(index+" "+currentString );
            char ch=s.charAt(index);
            if(isNum(ch)){
                int count=0;
                while(index<s.length() && isNum(s.charAt(index))){
                    count= count*10 + s.charAt(index)-'0';
                    index++;
                }
                
                prevString.push(currentString.toString());
                multiplier.push(count);
                currentString=new StringBuilder();
            }else if(ch==']'){
                int count=multiplier.pop();
                StringBuilder concatenatedString=new StringBuilder();
                while(count>0){
                    concatenatedString.append(currentString.toString());
                    count--;
                }
                
                currentString= new StringBuilder(prevString.pop() + concatenatedString.toString());
            }else{
                currentString.append(s.charAt(index));
            }
        }
        
        return currentString.toString();
    }
    
    boolean isNum(char c){
        return c>='0' && c<='9';
    }
    
    boolean isChar(char c){
        return c>='a' && c<='z';
    }
    
}