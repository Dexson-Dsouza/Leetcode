class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> prevChars=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(prevChars.size()>0 && prevChars.peek()[0]==(c-'a')){
                prevChars.peek()[1]++;
                if(prevChars.peek()[1]==k){
                    prevChars.pop();
                }
            }else{
                prevChars.push(new int[]{c-'a',1});
            }
        }
        
        StringBuilder resultStr=new StringBuilder();
        while(prevChars.size()>0){
            char ch= (char)('a'+prevChars.peek()[0]);
            int count = prevChars.peek()[1];
            prevChars.pop();
            for(int i=0;i<count;i++){
                resultStr.append(ch);
            }
        }
        return resultStr.reverse().toString();
    }
}