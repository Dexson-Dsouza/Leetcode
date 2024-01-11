class Solution {
    public String decodeString(String s) {
        Stack<Integer> prev_count=new Stack<>();
        Stack<String> prev_string=new Stack<>();
        char[] s_arr = s.toCharArray();
        StringBuilder decoded_str = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char cur = s_arr[i];
            
            if(isCharacter(cur)){
                decoded_str.append(cur);
            }else if(isNum(cur)){
                
                int index = i;
                int count = 0;
                while(index<s.length() && isNum(s_arr[index])){
                    count = count*10 + (s_arr[index]-'0');
                    index++;
                }
                i = index;
                prev_string.push(decoded_str.toString());
                prev_count.push(count);
                decoded_str = new StringBuilder();
            }else if(cur==']'){
                int count = prev_count.pop();
                String prev_str = prev_string.pop();
                StringBuilder repeated_str = new StringBuilder();
                while(count>0){
                    count--;
                    repeated_str.append(decoded_str);
                }
                
                decoded_str = new StringBuilder(prev_str.toString() + repeated_str.toString());
                
            }
            // System.out.println(decoded_str);
        }
        return decoded_str.toString();
    }
        
        boolean isCharacter(char ch){
            return ch>='a' && ch<='z';
        }
        boolean isNum(char ch){
            return ch>='0' && ch<='9';
        }
}