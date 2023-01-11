class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int maxNum = getMaxNum(s);
        int minNum = getMinNum(s);
        return maxNum-minNum;
    }
    
    public int getMaxNum(String s){
        char x = s.charAt(0);
        char y = '9';

        for(char ch:s.toCharArray()){
            if(ch!=y){
                x=ch;
                break;
            }
        }
        char[] numArr = s.toCharArray();
        
        for(int i=0;i<numArr.length;i++){
            if(numArr[i]==x){
                numArr[i]=y;
            }
        }
        return Integer.parseInt(new String(numArr));
    }
    
    public int getMinNum(String s){
        char x='0',y='0';

        if(s.charAt(0)!='1'){
            x = s.charAt(0);
            y = '1';
        }else{
            for(char ch:s.toCharArray()){
                if(ch>'1'){
                    x=ch;
                    
                    break;
                }
            }
        }
        
        char[] numArr = s.toCharArray();
        
        for(int i=0;i<numArr.length;i++){
            if(numArr[i]==x){
                numArr[i]=y;
            }
        }
        return Integer.parseInt(new String(numArr));
    }
}