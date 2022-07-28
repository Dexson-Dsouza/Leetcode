class Solution {
    public String decodeString(String s) {
        return decode(s,0,s.length());
    }
    
    public String decode(String s, int start, int end){
        StringBuilder decodedStr=new StringBuilder();
        Deque<String> prevStr=new LinkedList<>();
        Deque<Integer> multiplier=new LinkedList<>();
        
        while(start<end){
            if(s.charAt(start)==']'){
                int repeatCount = multiplier.pollLast();
                StringBuilder repeatedString=new StringBuilder();
                for(int i=0;i<repeatCount;i++){
                    repeatedString.append(decodedStr.toString());
                }
                
                decodedStr = new StringBuilder(prevStr.pollLast() + repeatedString.toString()); 
            }else if(isNum(s.charAt(start))){
                int num=0;
                while(isNum(s.charAt(start))){
                    num = num*10 + (s.charAt(start)-'0');
                    start++;
                }
                multiplier.addLast(num);
                prevStr.addLast(decodedStr.toString());
                decodedStr=new StringBuilder("");
            }else{
                decodedStr.append(s.charAt(start));
            }
            start++;
        }
        return decodedStr.toString();
    }
    
    boolean isNum(char ch){
        return ch>='0' && ch<='9';
    }
}