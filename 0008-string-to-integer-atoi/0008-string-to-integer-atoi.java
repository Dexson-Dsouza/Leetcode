class Solution {
    public int myAtoi(String s) {
        int index=0;
        char[] strArr=s.trim().toCharArray();
        int inputLen=strArr.length;
        boolean isNegative=false;
        int num=0;
        
        if(inputLen==0){
            return num;
        }
        if(strArr[index]=='-' || strArr[index]=='+'){
            isNegative = strArr[index]=='-';
            index++;
        }
        
        while(index<inputLen && isValid(strArr[index])){
            int digit = strArr[index]-'0';
            if(isNegative==false){
                if(num > (Integer.MAX_VALUE-digit)/10 ){
                    return Integer.MAX_VALUE;
                }else{
                    num = num*10 + digit;
                }
            }else{
                if( num*-1 < (Integer.MIN_VALUE+digit)/10 ){
                    return Integer.MIN_VALUE;
                }else{
                    num = num*10 + digit;
                }
            }
            index++;
        }
        if(isNegative){
            num*=-1;
        }
        return num;
    }
    
    public boolean isValid(char ch){
        return ch>='0' && ch<='9';
    }
}