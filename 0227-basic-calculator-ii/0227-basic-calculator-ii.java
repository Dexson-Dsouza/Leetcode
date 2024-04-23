class Solution {
    public int calculate(String s) {
        Stack<Character> operations=new Stack<>();
        Stack<Integer> numbers=new Stack<>();
        numbers.push(0);
        operations.push('+');
        
        int index=0;
        while(index<s.length()){
            if(s.charAt(index)==' '){
                index++;
            }else if(isNum(s.charAt(index))){
                
                int num=0;
                while(index<s.length() && isNum(s.charAt(index))){
                    num = num*10 + (s.charAt(index)-'0');
                    index++;
                }
                
                if(operations.size()>0 &&(operations.peek() =='*' || operations.peek()=='/')){
                    int firstNum=numbers.pop();
                    char op = operations.pop();
                    if(op=='*'){
                        num=firstNum*num;
                    }else{
                        num=firstNum/num;
                    }
                }
                numbers.push(num);
            }else{
                operations.push(s.charAt(index++));
            }
        }
        
        int res=0;
        while(operations.size()>0){
            int num=numbers.pop();
            char op = operations.pop();
            if(op=='-'){
                res-=num;
            }else{
                res+=num;
            }
        }
        return res;
    }
    
    public boolean isNum(char ch){
        return ch>='0' && ch<='9';
    }
}