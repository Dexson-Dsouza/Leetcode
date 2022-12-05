class Solution {
    public String decodeString(String s) {
        Stack<String> prevStringStack=new Stack<>();
        Stack<Integer> repetitionCountStack=new Stack<>();
        
        StringBuilder currentString=new StringBuilder();
        char[] strArr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char ch = strArr[i];
            if(isChar(ch)){
                currentString.append(ch);
            }else if(isNum(ch)){
                int j = i;
                int num = 0;
                while(j<s.length() && isNum(strArr[j])){
                    int digit = strArr[j]-'0';
                    num = num*10 + digit;
                    j++;
                }
                prevStringStack.push(currentString.toString());
                currentString=new StringBuilder();
                repetitionCountStack.push(num);
                i=j;
            }else{
                int prevCount = repetitionCountStack.pop();
                StringBuilder repeatedString=new StringBuilder();
                for(int count = 0; count < prevCount; count ++){
                    repeatedString.append(currentString.toString());
                }
                String prevString = prevStringStack.pop();
                currentString = new StringBuilder(prevString);
                currentString.append(repeatedString);
            }
        }
        return currentString.toString();
    }
    
    public boolean isChar(char c){
        return c>='a' && c<='z';
    }
    public boolean isNum(char c){
        return c>='0' && c<='9';
    }
}